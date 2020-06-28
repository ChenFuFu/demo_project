package com.chen.springbatch.model;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;

/**
 * @Author Chen
 * @Date 2020/6/9
 * @Time 16:58
 * @Annotate
 **/
@Data
@Table(name="test_user")
public class User{
    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 职称职别
     */
    private String title;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生时间
     */
    private Date dateOfBirth;

    /**
     * sys_create_time
     */
    private Date sysCreateTime;

    /**
     * sys_create_user
     */
    private String sysCreateUser;

    /**
     * sys_update_time
     */
    private Date sysUpdateTime;

    /**
     * sys_update_user
     */
    private String sysUpdateUser;

    public User() {
    }

}