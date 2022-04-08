package com.example.dynamic_data_source.dao.read;

import com.example.dynamic_data_source.entity.read.ReadUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Chen
 * @Date 2022/4/7
 * @Time 09:38
 * @Description
 */

@Mapper
public interface ReadUserMapper {

    List<ReadUser> queryReadUserList(ReadUser readUser);

    int addReadUser(ReadUser readUser);
}
