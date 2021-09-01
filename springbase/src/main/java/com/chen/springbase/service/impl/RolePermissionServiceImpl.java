package com.chen.springbase.service.impl;

import com.chen.springbase.entity.RolePermissionEntity;
import com.chen.springbase.mapper.RolePermissionMapper;
import com.chen.springbase.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2021/09/01
 * @Time 16:38:49
 * @Description 角色权限关系
 **/

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public int insert(RolePermissionEntity rolePermission) {
        return rolePermissionMapper.insert(rolePermission);
    }


    @Override
    public int delete(int id) {
        return rolePermissionMapper.delete(id);
    }


    @Override
    public int update(RolePermissionEntity rolePermission) {
        return rolePermissionMapper.update(rolePermission);
    }


    @Override
    public RolePermissionEntity load(int id) {
        return rolePermissionMapper.load(id);
    }


    @Override
    public Map<String,Object> pageList(Map<String, Object> params) {

        List<RolePermissionEntity> pageList = rolePermissionMapper.pageList(params);
        int totalCount = rolePermissionMapper.pageListCount(params);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

}