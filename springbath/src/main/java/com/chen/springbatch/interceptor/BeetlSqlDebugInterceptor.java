package com.chen.springbatch.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.beetl.sql.ext.DebugInterceptor;

/**
 * @Author Chen
 * @Date 2020/6/10
 * @Time 10:27
 * @Annotate 将beetlsql日志输出到logback文件中
 **/
@Slf4j
public class BeetlSqlDebugInterceptor extends DebugInterceptor {
    @Override
    protected void println(String str) {
        // System.lineSeparator() 插入换行符 此方法可跨平台
        log.debug(System.lineSeparator() + str);
    }
}
