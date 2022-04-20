package com.example.dynamic_data_source.service.impl;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.example.dynamic_data_source.entity.read.ReadUser;
import com.example.dynamic_data_source.entity.write.WriteUser;
import com.example.dynamic_data_source.exception.BDException;
import com.example.dynamic_data_source.service.WriteReadUserService;
import com.example.dynamic_data_source.service.read.ReadUserService;
import com.example.dynamic_data_source.service.write.WriteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Chen
 * @Date 2022/4/15
 * @Time 09:27
 * @Description
 */

@Service
public class WriteReadUserServiceImpl implements WriteReadUserService {

    @Autowired
    private WriteUserService writeUserService;

    @Autowired
    private ReadUserService readUserService;

    @Override
    @DSTransactional
    public int addWriteReadUser(WriteUser writeUser, ReadUser readUser) throws BDException {
        int writeRes = writeUserService.addWriteUser(writeUser);
        if (writeRes == 0) {
            throw new BDException("新增写库数据异常！");
        }

        int readRes = readUserService.addReadUser(readUser);
        if (readRes == 0) {
            throw new BDException("新增读库数据异常！");
        }
        return 2;
    }
}
