package com.chen.springbase.mapper;

import com.chen.springbase.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author Chen
 * @Date 2021/09/05
 * @Time 18:26:24
 * @Description 用户角色对应关系
 **/

@Mapper
public interface UserRoleMapper {

    /**
     * 新增
     * @author Chen
     * @date 2021/09/05
     **/
    int insert(UserRoleEntity userRole);

    /**
     * 刪除
     * @author Chen
     * @date 2021/09/05
     **/
    int delete(int id);

    /**
     * 更新
     * @author Chen
     * @date 2021/09/05
     **/
    int update(UserRoleEntity userRole);

    /**
     * 查询 根据主键 id 查询
     * @author Chen
     * @date 2021/09/05
     **/
    UserRoleEntity load(int id);

    /**
     * 查询 分页查询
     * @author Chen
     * @date 2021/09/05
     **/
    List<UserRoleEntity> pageList(Map<String, Object> map);

    /**
     * 查询 分页查询 count
     * @author Chen
     * @date 2021/09/05
     **/
    int pageListCount(Map<String, Object> map);

}