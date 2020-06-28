package com.chen.springbatch.listener;

import com.chen.springbatch.common.LogConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * @Author Chen
 * @Date 2020/6/9
 * @Time 17:24
 * @Annotate 通用步监听
 **/
@Slf4j
@Component
public class CommonStepListener extends StepExecutionListenerSupport {
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        int readCount = stepExecution.getReadCount();
        int filterCount = stepExecution.getFilterCount();
        int commitCount = stepExecution.getCommitCount();
        int writeCount = stepExecution.getWriteCount();
        log.info(LogConstants.LOG_TAG + " read:" + readCount + ", filter:"+filterCount + ",commit:"
                + commitCount + ",write:"+writeCount);
        return stepExecution.getExitStatus();
    }
}
