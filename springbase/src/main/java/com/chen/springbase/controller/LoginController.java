package com.chen.springbase.controller;

import com.chen.springbase.entity.RoleEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Chen
 * @Date 2021/8/12
 * @Time 09:28
 * @Description
 **/

@RestController
@RequestMapping("/user/")
public class LoginController {
    public void inde (RoleEntity roleEntity) {
        System.out.println(roleEntity);
    }
}
