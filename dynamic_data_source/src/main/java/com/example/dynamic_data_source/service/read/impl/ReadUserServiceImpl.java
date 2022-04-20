package com.example.dynamic_data_source.service.read.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.example.dynamic_data_source.dao.read.ReadUserMapper;
import com.example.dynamic_data_source.entity.read.ReadUser;
import com.example.dynamic_data_source.service.read.ReadUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Chen
 * @Date 2022/4/8
 * @Time 09:42
 * @Description
 */

@Service
@DS("slave")
public class ReadUserServiceImpl implements ReadUserService {

    @Autowired
    private ReadUserMapper readUserMapper;

    /**
     * 查询用户列表
     * @param readUser
     * @return
     */
    @Override
    public List<ReadUser> queryReadUserList(ReadUser readUser) {
        return readUserMapper.queryReadUserList(readUser);
    }

    @Override
    @DSTransactional
    public int addReadUser(ReadUser readUser) {
        return readUserMapper.addReadUser(readUser);
    }
}
