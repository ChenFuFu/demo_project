package com.chen.springbatch.batch.service;

import com.chen.springbatch.common.LogConstants;
import com.chen.springbatch.common.SyncConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2020/6/11
 * @Time 09:52
 * @Annotate job启动服务
 **/

@Slf4j
@Service
public class JobLauncherService {

    @Autowired
    private JobLauncher jobLauncher;

    public Map<String, Object> startJob(Job job, JobParameters jobParameters) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String, Object> resultMap = new HashMap<>();

        // 计时开始 stopwatch 为封装后的计时工具
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(job.getName());

        // JobExplorer 主要负责从JobRepository中获取执行的信息，包括获取作业实例、获取作业执行器、
        // 获取作恶步执行器、获取正在运行的作业执行器、获取作业列表等操作；
        JobExecution run = jobLauncher.run(job, jobParameters);

        StringBuffer stringBuffer = new StringBuffer();
        // 获取执行步骤中的返回结果
        Collection<StepExecution> stepExecutions = run.getStepExecutions();
        stepExecutions.forEach(stepExecution -> {
            stringBuffer.append("readCount:" + stepExecution.getReadCount() + LogConstants.LOG_STR_COMMA);
            stringBuffer.append("filterCount:" + stepExecution.getFilterCount() + LogConstants.LOG_STR_COMMA);
            stringBuffer.append("commitCount:" + stepExecution.getCommitCount() + LogConstants.LOG_STR_COMMA);
            stringBuffer.append("writeCount:" + stepExecution.getWriteCount() + LogConstants.LOG_STR_COMMA);
        });

        // 计时结束
        stopWatch.stop();

        // 获取退出状态 0 成功 1 失败
        ExitStatus exitStatus = run.getExitStatus();
        String returnStr = System.lineSeparator() + "result" + stringBuffer
                + System.lineSeparator() + "exitStatus:" + exitStatus
                + System.lineSeparator() + "time:" + stopWatch.prettyPrint();
        log.info(returnStr);
        resultMap.put(SyncConstants.STR_RETURN_RESULT, returnStr);
        resultMap.put(SyncConstants.STR_RETURN_EXITSTATUS, exitStatus);
        return resultMap;
    }

}
