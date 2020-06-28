package com.chen.springbatch.model;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @Author Chen
 * @Date 2020/6/17
 * @Time 10:10
 * @Annotate 定时任务
 **/

@Data
@Table(name = "quartz_job")
public class QuartzJob {

    /**
     * job任务id
     */
    private String jobId;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * 描述
     */
    private String description;

    /**
     * 任务执行时调用哪个类的方法 包名+类名，完全限定名
     */
    private String beanName;

    /**
     * 触发器名称
     */
    private String triggerName;

    /**
     * 任务状态
     */
    private Integer jobStatus;

    /**
     * 任务名
     */
    private String jobName;

    /**
     * 组名
     */
    private String groupName;
}
