package com.chen.springbase.service.impl;

import com.chen.springbase.entity.UserRoleEntity;
import com.chen.springbase.mapper.UserRoleMapper;
import com.chen.springbase.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2021/09/05
 * @Time 18:26:24
 * @Description 用户角色对应关系
 **/

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public int insert(UserRoleEntity userRole) {
        return userRoleMapper.insert(userRole);
    }


    @Override
    public int delete(int id) {
        return userRoleMapper.delete(id);
    }


    @Override
    public int update(UserRoleEntity userRole) {
        return userRoleMapper.update(userRole);
    }


    @Override
    public UserRoleEntity load(int id) {
        return userRoleMapper.load(id);
    }


    @Override
    public Map<String,Object> pageList(Map<String, Object> params) {

        List<UserRoleEntity> pageList = userRoleMapper.pageList(params);
        int totalCount = userRoleMapper.pageListCount(params);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

}