package com.example.dynamic_data_source.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.dynamic_data_source.entity.read.ReadUser;
import com.example.dynamic_data_source.entity.write.WriteUser;
import com.example.dynamic_data_source.exception.BDException;
import com.example.dynamic_data_source.service.WriteReadUserService;
import com.example.dynamic_data_source.service.read.ReadUserService;
import com.example.dynamic_data_source.service.write.WriteUserService;
import com.example.dynamic_data_source.utils.ResultHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Chen
 * @Date 2022/4/8
 * @Time 09:34
 * @Description
 */

@RestController
public class IndexController {

    @Autowired
    private WriteUserService writeUserService;

    @Autowired
    private ReadUserService readUserService;

    @Autowired
    private WriteReadUserService writeReadUserService;

    @RequestMapping("/add/writeUser")
    public Map<String, Object> addWriteUser(@RequestBody WriteUser writeUser) {
        int addFlag = writeUserService.addWriteUser(writeUser);
        if (addFlag == 0) {
            return ResultHelper.systemException();
        } else {
            return ResultHelper.success();
        }
    }

    @RequestMapping("add/writeReadUser")
    public Map<String, Object> addWriteReadUser(@RequestBody Map<String, Object> params) {
        WriteUser writeUser = JSONObject.parseObject(JSONObject.toJSONString(params.get("writeUser")), WriteUser.class);
        ReadUser readUser = JSONObject.parseObject(JSONObject.toJSONString(params.get("readUser")), ReadUser.class);

        try {
            int addRes = writeReadUserService.addWriteReadUser(writeUser, readUser);
            return ResultHelper.success();
        } catch (BDException e) {
            return ResultHelper.systemException(e.getMsg());
        }
    }
}
