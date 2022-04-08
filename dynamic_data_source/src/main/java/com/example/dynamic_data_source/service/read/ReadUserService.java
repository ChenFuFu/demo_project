package com.example.dynamic_data_source.service.read;

import com.example.dynamic_data_source.entity.read.ReadUser;

import java.util.List;

/**
 * @Author Chen
 * @Date 2022/4/8
 * @Time 09:37
 * @Description
 */

public interface ReadUserService {

    List<ReadUser> queryReadUserList(ReadUser readUser);

    int addReadUser(ReadUser readUser);
}
