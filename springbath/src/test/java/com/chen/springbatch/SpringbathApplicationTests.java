package com.chen.springbatch;

import com.chen.springbatch.batch.config.BeetlsqlBatchConfig;
import com.chen.springbatch.batch.service.JobLauncherService;
import com.chen.springbatch.batch.service.SpringBathService;
import com.chen.springbatch.quartz.job.SpringBathJob;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * beetlsql测试类
 * @author mason
 * @since 2019/6/1
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbathApplication.class, BeetlsqlBatchConfig.class})
@Slf4j
public class SpringbathApplicationTests {

    @Autowired
    private JobLauncherService jobLauncherService;

    @Autowired
    private Job beetlsqlJob;

    @Autowired
    private SpringBathService springBathService;


    /**
     * 此处报ant-javafx.jar错误是因为spring-core的jar包中ResourceUtile java文件 87 行run方法判断ant-javafx文件协议是不是file
     * 此处返回的为jar所以抛了异常
     *
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     */
    @Test
    public void testBeetlsqlJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        springBathService.startBatchJob();
    }

    @Test
    public void qurtzStart() throws SchedulerException, InterruptedException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // withIdentity 设置job名称和组名
        JobDetail job = newJob(SpringBathJob.class)
                .withIdentity("myJob10", "group1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("myTrigger10", "group1")
                .withSchedule(cronSchedule("* * * * * ? *"))
                .build();
        // 调度job和触发器
        scheduler.scheduleJob(job, trigger);
        Thread.sleep(1000);
        scheduler.shutdown();
    }


}


