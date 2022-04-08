package com.example.dynamic_data_source.dao.write;

import com.example.dynamic_data_source.entity.write.WriteUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author lc
 * @Date 2022/4/7
 * @Time 09:39
 * @Description
 */

@Mapper
public interface WriteUserMapper {

    List<WriteUser> queryWriteUserList(WriteUser writeUser);

    int addWriteUser(WriteUser writeUser);
}
