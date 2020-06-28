package com.chen.springbatch.dao.origin;

import com.chen.springbatch.model.User;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2020/6/9
 * @Time 17:12
 * @Annotate 源数据源dao层 使用beetlsql内置crud
 **/

@Repository
public interface OriginUserDao extends BaseMapper<User> {
    List<User> getOriginUser(Map<String,Object> params);
}
