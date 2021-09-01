package com.chen.springbase.entity;


/**
 * @Author Chen
 * @Date 2021-08-27
 * @Time 10:02:26
 * @Description 用户信息
 **/
public class PermissionEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 权限名称
     */
    private String permission;

    /**
     * 权限描述
     */
    private String desc;


    public PermissionEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}