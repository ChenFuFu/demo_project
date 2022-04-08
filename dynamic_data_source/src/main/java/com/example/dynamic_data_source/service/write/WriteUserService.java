package com.example.dynamic_data_source.service.write;

import com.example.dynamic_data_source.entity.write.WriteUser;

import java.util.List;

/**
 * @Author Chen
 * @Date 2022/4/8
 * @Time 09:38
 * @Description
 */

public interface WriteUserService {

    List<WriteUser> queryWriteUserList(WriteUser writeUser);

    int addWriteUser(WriteUser writeUser);
}
