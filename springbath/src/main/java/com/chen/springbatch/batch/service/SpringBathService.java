package com.chen.springbatch.batch.service;

import com.chen.springbatch.common.LogConstants;
import com.chen.springbatch.common.SyncConstants;
import com.chen.springbatch.util.JobUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Chen
 * @Date 2020/6/15
 * @Time 09:40
 * @Annotate
 **/

@Slf4j
@Service
public class SpringBathService {

    @Autowired
    private JobLauncherService jobLauncherService;

    @Autowired
    private Job beetlsqlJob;

    public boolean startBatchJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = JobUtil.makeJobParameters();
        Map<String, Object> stringObjectMap = jobLauncherService.startJob(beetlsqlJob, jobParameters);
        String exitStatus = stringObjectMap.get(SyncConstants.STR_RETURN_EXITSTATUS).toString();
        if (ExitStatus.COMPLETED.equals(exitStatus)) {
            log.info(LogConstants.LOG_TAG + "spring batch 调用成功");
            return true;
        } else {
            log.info(LogConstants.LOG_TAG + "spring batch 调用失败");
            return false;
        }
    }
}
