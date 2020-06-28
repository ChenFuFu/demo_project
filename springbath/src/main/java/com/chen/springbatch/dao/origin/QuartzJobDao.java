package com.chen.springbatch.dao.origin;

import com.chen.springbatch.model.QuartzJob;
import com.chen.springbatch.model.User;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Chen
 * @Date 2020/6/14
 * @Time 11:48
 * @Annotate
 **/

@Repository
public interface QuartzJobDao extends BaseMapper<User> {

    /**
     * 查询定时任务信息
     * @param JobId
     * @return
     */
    QuartzJob selectQuartzJob(String JobId);

    /**
     * 修改定时任务信息
     * @param QuartzJob
     * @return
     */
    Integer updateQuartzJob(QuartzJob QuartzJob);

    /**
     * 新增定时任务信息
     * @param QuartzJob
     * @return
     */
    Integer insertQuartzJob(QuartzJob QuartzJob);

    /**
     * 删除定时任务信息
     * @param jobId
     * @return
     */
    Integer deleteQuartzJob(String jobId);
}
