package com.example.dynamic_data_source.controller;

import com.example.dynamic_data_source.service.read.ReadUserService;
import com.example.dynamic_data_source.service.write.WriteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/add/readAndWriteUser")
    public Map<String, Object>
}
