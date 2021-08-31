package com.chen.springbase.bean;

/**
 * @Author Chen
 * @Date 2021-08-23
 * @Time 19:33:52
 * @Description 用户信息表
 **/
public class User {

    /**
     * id
     */
    private Long id;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户
     */
    private String account;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}