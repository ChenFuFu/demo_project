package com.chen.springbatch.batch.step.writer;

import com.chen.springbatch.dao.target.TargetUserDao;
import com.chen.springbatch.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Chen
 * @Date 2020/6/10
 * @Time 14:34
 * @Annotate user内容写组件
 **/


@Slf4j
public class UserItemWriter implements ItemWriter<User> {

    @Autowired
    private TargetUserDao targetUserDao;

    @Override
    public void write(List<? extends User> list) throws Exception {
        // 批量插入数据 insertBatch()
        // originUserDao 为md文件名 insertUser为对应sql名称
        targetUserDao.getSQLManager().updateBatch("targetUserDao.cleanUser", list);
        targetUserDao.getSQLManager().updateBatch("targetUserDao.insertUser", list);
    }
}
