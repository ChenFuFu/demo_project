package com.chen.springbatch.util;

import com.chen.springbatch.common.LogConstants;
import com.chen.springbatch.model.QuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Chen
 * @Date 2020/6/14
 * @Time 13:48
 * @Annotate quartz定时任务工具类
 **/

@Slf4j
@Component
public class QuartzUtil {

    @Autowired
    private Scheduler scheduler;

    /**
     * 开始执行任务
     */
    public void startJob() {
        try  {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建定时任务
     * @param
     * @throws SchedulerException
     */
    public String addJob(QuartzJob quartzJob) throws SchedulerException,
        ClassNotFoundException, IllegalAccessException, InstantiationException {
        //通过类名获取实体类，即要执行的定时任务的类
        Class jobBean = Class.forName(quartzJob.getBeanName());
        Job executeJob = (Job)jobBean.newInstance();

        // 通过执行的任务类创建任务实例
        JobDetail jobDetail = JobBuilder.newJob(executeJob.getClass())
                .withIdentity(quartzJob.getJobName()).build();

        // 构建触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzJob.getTriggerName())
                .startNow().withSchedule(CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression()))
                .build();

        // 执行定时任务
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formatDate = simpleDateFormat.format(date);
        log.info(LogConstants.LOG_TAG + "任务执行时间为:" + formatDate);
        return formatDate;
    }

    /**
     * 修改定时任务
     * @param quartzJob
     * @return
     */
    public String modifyJob(QuartzJob quartzJob) throws SchedulerException {
        Date newDate = null;
        TriggerKey triggerKey = new TriggerKey(quartzJob.getTriggerName());
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oleDate = cronTrigger.getCronExpression();
        // 构建cron对象，传入新的trigger触发器中
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression());
        Trigger newTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                .withSchedule(cronScheduleBuilder).build();
        newDate = scheduler.rescheduleJob(triggerKey, newTrigger);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formatDate = simpleDateFormat.format(newDate);
        log.info(LogConstants.LOG_TAG + "修改后下次任务运行时间为：" + formatDate);
        return formatDate;
    }

    /**
     * 删除定时任务
     * @param quartzJob
     */
    public String removeJob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = new JobKey(quartzJob.getJobName());
        return String.valueOf(scheduler.deleteJob(jobKey));
    }

    /**
     * 恢复定时任务
     * @param quartzJob
     * @throws SchedulerException
     */
    public void recoverJob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = new JobKey(quartzJob.getJobName());
        scheduler.resumeJob(jobKey);
    }

    /**
     * 立即执行定时任务
     * @param quartzJob
     * @throws SchedulerException
     */
    public void runJobNow(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = new JobKey(quartzJob.getJobName());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 暂停定时任务
     * @param quartzJob
     * @throws SchedulerException
     */
    public void stopjob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = new JobKey(quartzJob.getJobName());
        scheduler.pauseJob(jobKey);
    }

    /**
     * 关闭任务调度器
     * @throws SchedulerException
     */
    public void shoutdownJob() throws SchedulerException {
        scheduler.shutdown();
    }
}
