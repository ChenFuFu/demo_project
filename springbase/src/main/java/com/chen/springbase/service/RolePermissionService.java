package com.chen.springbase.service;

import com.chen.springbase.entity.RolePermissionEntity;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2021/09/01
 * @Time 16:25:34
 * @Description 角色权限关系
 **/

public interface RolePermissionService {

    /**
     * 新增
     */
    public  int insert(RolePermissionEntity rolePermission);

    /**
     * 删除
     */
    public int delete(int id);

    /**
     * 更新
     */
    public int update(RolePermissionEntity rolePermission);

    /**
     * 根据主键 id 查询
     */
    public RolePermissionEntity load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(Map<String, Object> params);

}