package com.chen.springbatch.controller;

import com.alibaba.fastjson.JSONObject;
import com.chen.springbatch.common.QuartzConstants;
import com.chen.springbatch.dao.origin.QuartzJobDao;
import com.chen.springbatch.model.QuartzJob;
import com.chen.springbatch.util.QuartzUtil;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2020/6/14
 * @Time 15:12
 * @Annotate
 **/

@Controller
public class QuartzController {

    @Autowired
    private QuartzUtil quartzUtil;

    @Autowired
    private QuartzJobDao quartzJobDao;

    /**
     * 新增定时任务
     * {
     *      "cronExpression": "* * * * * ? *",
     *      "description": "",
     *      "triggerName": "testTrigger1",
     *      jobName: "testJob1"
     * }
     *
     * @param map
     * @return
     */
    @RequestMapping("/createJob")
    @ResponseBody
    public String createJob(@RequestBody Map<String, String > map) {
        QuartzJob quartzJob = JSONObject.parseObject(JSONObject.toJSONString(map), QuartzJob.class);
        quartzJob.setJobId(String.valueOf(System.currentTimeMillis()));
        quartzJob.setBeanName("com.chen.springbatch.quartz.job.SpringBathJob");
        quartzJob.setJobStatus(QuartzConstants.STATE_NORMAL);
        
        Integer addjob = quartzJobDao.getSQLManager().update("quartzJob.insertQuartzJob", quartzJob);
        if (quartzJob.getCronExpression().isEmpty()) {
            return "启动失败";
        }
        if (quartzJob.getTriggerName().isEmpty()) {
            return "启动失败";
        }
        if (quartzJob.getJobName().isEmpty()) {
            return "启动失败";
        }

        try {
            String date = quartzUtil.addJob(quartzJob);
            if (!date.isEmpty()) {
                return JSONObject.toJSONString(quartzJob);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return "启动失败";
    }

    /**
     * 获取定时任务信息
     * {
     *      "jobId": "1592473163894",
     * }
     * @param map
     * @return
     */
    @RequestMapping("/readJob")
    @ResponseBody
    public String readJob(@RequestBody Map<String, String > map) {
        QuartzJob quartzJob = JSONObject.parseObject(JSONObject.toJSONString(map), QuartzJob.class);
        List<QuartzJob> getQuartzJobInfo = quartzJobDao.getSQLManager().select("quartzJob.selectQuartzJob",QuartzJob.class, quartzJob);
        return JSONObject.toJSONString(getQuartzJobInfo);
    }

    /**
     * 修改定时任务
     * {
     * 	"jobId": "1592473163894",
     * 	"cronExpression": "0 0/5 * * * ? ",
     * }
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateJob")
    @ResponseBody
    public String updateJob(@RequestBody Map<String, String> map) {
        QuartzJob quartzJob = JSONObject.parseObject(JSONObject.toJSONString(map), QuartzJob.class);
        int updateJob = quartzJobDao.getSQLManager().update("quartzJob.updateQuartzJob", quartzJob);

        if (updateJob == 1) {
            List<QuartzJob> getQuartzJobInfo = quartzJobDao.getSQLManager().select("quartzJob.selectQuartzJob",QuartzJob.class, quartzJob);
            try {
                return quartzUtil.modifyJob(getQuartzJobInfo.get(0));
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        return "0";
    }

    /**
     * 删除定时任务
     * {
     * 	"jobId": "1592473163894",
     * }
     *
     * @param map
     * @return true/false
     */
    @RequestMapping("/deleteJob")
    @ResponseBody
    public String deleteJob(@RequestBody Map<String, String> map) {
        QuartzJob quartzJob = JSONObject.parseObject(JSONObject.toJSONString(map), QuartzJob.class);
        quartzJob.setJobStatus(QuartzConstants.STATE_NONE);
        if (quartzJob.getJobId().isEmpty()) {
            return "jobid为空！";
        }

        int delJob = quartzJobDao.getSQLManager().update("quartzJob.updateQuartzJob", quartzJob);
        if (delJob == 1) {
            List<QuartzJob> getQuartzJobInfo = quartzJobDao.getSQLManager().select("quartzJob.selectQuartzJob",QuartzJob.class, quartzJob);
            try {
                return quartzUtil.removeJob(getQuartzJobInfo.get(0));
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        return "false";
    }

    /**
     * 恢复启动暂停的定时任务
     * {
     * 	"jobId": "1592473163894",
     * }
     * @param map
     * @return
     */
    @RequestMapping("/recoverJob")
    @ResponseBody
    public String recoverJob(@RequestBody Map<String, String> map) {
        QuartzJob quartzJob = JSONObject.parseObject(JSONObject.toJSONString(map), QuartzJob.class);
        quartzJob.setJobStatus(QuartzConstants.STATE_NORMAL);
        if (quartzJob.getJobId().isEmpty()) {
            return "jobid为空！";
        }

        int recJob = quartzJobDao.getSQLManager().update("quartzJob.updateQuartzJob", quartzJob);
        if (recJob == 1) {
            List<QuartzJob> getQuartzJobInfo = quartzJobDao.getSQLManager()
                .select("quartzJob.selectQuartzJob",QuartzJob.class, quartzJob);
            try {
                quartzUtil.recoverJob(getQuartzJobInfo.get(0));
                return "true";
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        return "false";
    }

    /**
     * 立即执行定时任务
     * {
     * 	"jobId": "1592473163894",
     * }
     * @param map
     * @return
     */
    @RequestMapping("/runJobNow")
    @ResponseBody
    public String runJobNow(@RequestBody Map<String, String> map) {
        QuartzJob quartzJob = JSONObject.parseObject(JSONObject.toJSONString(map), QuartzJob.class);
        if (quartzJob.getJobId().isEmpty()) {
            return "jobid为空！";
        }

        List<QuartzJob> getQuartzJobInfo = quartzJobDao.getSQLManager().select("quartzJob.selectQuartzJob",QuartzJob.class, quartzJob);

        try {
            quartzUtil.runJobNow(getQuartzJobInfo.get(0));
            return "true";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "false";
    }

    /**
     * 暂停定时任务
     * {
     * 	"jobId": "1592473163894",
     * }
     * @param map
     * @return
     */
    @RequestMapping("/stopjob")
    @ResponseBody
    public String stopjob(@RequestBody Map<String, String> map) {
        QuartzJob quartzJob = JSONObject.parseObject(JSONObject.toJSONString(map), QuartzJob.class);
        quartzJob.setJobStatus(QuartzConstants.STATE_PAUSED);
        if (quartzJob.getJobId().isEmpty()) {
            return "jobid为空！";
        }

        int recJob = quartzJobDao.getSQLManager().update("quartzJob.updateQuartzJob", quartzJob);
        if (recJob == 1) {
            List<QuartzJob> getQuartzJobInfo = quartzJobDao.getSQLManager().select("quartzJob.selectQuartzJob",QuartzJob.class, quartzJob);
            try {
                quartzUtil.stopjob(getQuartzJobInfo.get(0));
                return "true";
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
        return "false";
    }

}
