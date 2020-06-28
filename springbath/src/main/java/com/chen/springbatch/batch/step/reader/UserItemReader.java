package com.chen.springbatch.batch.step.reader;

import com.chen.springbatch.dao.origin.OriginUserDao;
import com.chen.springbatch.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Chen
 * @Date 2020/6/10
 * @Time 14:17
 * @Annotate user 内容读组件
 **/


@Slf4j
public class UserItemReader implements ItemReader<User> {

    protected Map<String, Object> params;
    private List<User> items;

    @Autowired
    private OriginUserDao originUserDao;

    @Override
    public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (Objects.isNull(items)) {
            items = originUserDao.getSQLManager().select("originUser.getOriginUser", User.class, params);
            if (items.size() > 0) {
                return items.remove(0);
            }
        } else {
            if (!items.isEmpty()) {
                return items.remove(0);
            } else {
                items = null;
            }
        }
        return null;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
