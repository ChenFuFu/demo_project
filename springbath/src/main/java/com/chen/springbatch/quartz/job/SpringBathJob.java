package com.chen.springbatch.quartz.job;

import com.chen.springbatch.batch.service.SpringBathService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Chen
 * @Date 2020/6/14
 * @Time 11:03
 * @Annotate
 **/

@Slf4j
public class SpringBathJob implements Job{

    @Autowired
    private SpringBathService springBathService;

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        springBathService.startBatchJob();
    }

}
