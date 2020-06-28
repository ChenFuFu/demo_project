package com.chen.springbatch.batch.step.processor;

import com.chen.springbatch.common.LogConstants;
import com.chen.springbatch.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;

import java.util.Objects;

/**
 * @Author Chen
 * @Date 2020/6/11
 * @Time 15:34
 * @Annotate 数据处理组件
 **/


@Slf4j
public class UserItemProcessor implements ItemProcessor<User,User> {

    @Override
    public User process(User user) throws Exception {
        String title = user.getTitle();
        if (Objects.nonNull(title)) {
            // 如果获取到的有标题则把标题转为大写
            user.setTitle(title.toUpperCase());
        }
        log.info(LogConstants.LOG_TAG + "beetlsql item process:" + user.getName());
        return user;
    }
}
