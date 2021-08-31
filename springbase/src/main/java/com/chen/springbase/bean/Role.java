package com.chen.springbase.bean;

/**
 * @Author Chen
 * @Date 2021-08-25
 * @Time 20:30:09
 * @Description 用户信息
 **/
public class Role {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 角色
     */
    private String role;

    /**
     * 角色描述
     */
    private String desc;


    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}