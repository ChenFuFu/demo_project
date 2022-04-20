package com.example.dynamic_data_source.service;

import com.example.dynamic_data_source.entity.read.ReadUser;
import com.example.dynamic_data_source.entity.write.WriteUser;
import com.example.dynamic_data_source.exception.BDException;

/**
 * @Author Chen
 * @Date 2022/4/15
 * @Time 09:23
 * @Description 两个库同时操作
 */

public interface WriteReadUserService {

    int addWriteReadUser(WriteUser writeUser, ReadUser readUser) throws Exception;
}
