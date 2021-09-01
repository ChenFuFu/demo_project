package com.chen.springbase.mapper;

import com.chen.springbase.entity.RolePermissionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2021/09/01
 * @Time 15:33:23
 * @Description 用户信息
 **/

@Mapper
public interface RolePermissionMapper {

    /**
     * 新增
     * @author Chen
     * @date 2021/09/01
     **/
    int insert(RolePermissionEntity rolePermission);

    /**
     * 刪除
     * @author Chen
     * @date 2021/09/01
     **/
    int delete(int id);

    /**
     * 更新
     * @author Chen
     * @date 2021/09/01
     **/
    int update(RolePermissionEntity rolePermission);

    /**
     * 查询 根据主键 id 查询
     * @author Chen
     * @date 2021/09/01
     **/
    RolePermissionEntity load(int id);

    /**
     * 查询 分页查询
     * @author Chen
     * @date 2021/09/01
     **/
    List<RolePermissionEntity> pageList(Map<String, Object> map);

    /**
     * 查询 分页查询 count
     * @author Chen
     * @date 2021/09/01
     **/
    int pageListCount(Map<String, Object> map);

}