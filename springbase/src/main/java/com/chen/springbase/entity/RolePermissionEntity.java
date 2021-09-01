package com.chen.springbase.entity;

/**
 * @Author Chen
 * @Date 2021-09-01
 * @Time 15:27:10
 * @Description 角色权限关系
 **/
public class RolePermissionEntity {

    // private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * role_id
     */
    private Integer roleId;

    /**
     * permission_id
     */
    private Integer permissionId;


    public RolePermissionEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}