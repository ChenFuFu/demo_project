package com.chen.springbatch.batch.lintener;

import com.chen.springbatch.common.LogConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @Author Chen
 * @Date 2020/6/11
 * @Time 15:34
 * @Annotate 在结束或开始时执行指定操作
 **/

@Slf4j
public class BeetlsqlJobEndListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.debug(LogConstants.LOG_TAG + " batch job complete!");
        }
    }
}
