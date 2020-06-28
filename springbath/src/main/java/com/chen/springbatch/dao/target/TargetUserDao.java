package com.chen.springbatch.dao.target;

import com.chen.springbatch.model.User;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Chen
 * @Date 2020/6/10
 * @Time 10:49
 * @Annotate 目标数据源dao层 使用beetlsql内置crud
 **/

@Repository
public interface TargetUserDao extends BaseMapper<User> {
}

