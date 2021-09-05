package com.chen.springbase.service;

import com.chen.springbase.entity.UserRoleEntity;

import java.util.Map;

/**
 * @Author Chen
 * @Date 2021/09/05
 * @Time 18:26:24
 * @Description 用户角色对应关系
 **/

public interface UserRoleService {

    /**
     * 新增
     */
    public  int insert(UserRoleEntity userRole);

    /**
     * 删除
     */
    public int delete(int id);

    /**
     * 更新
     */
    public int update(UserRoleEntity userRole);

    /**
     * 根据主键 id 查询
     */
    public UserRoleEntity load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(Map<String, Object> params);

}