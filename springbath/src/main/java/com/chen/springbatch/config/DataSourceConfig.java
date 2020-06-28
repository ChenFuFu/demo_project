package com.chen.springbatch.config;

import com.chen.springbatch.interceptor.BeetlSqlDebugInterceptor;
import com.ibeetl.starter.BeetlSqlMutipleSourceCustomize;
import org.beetl.sql.core.Interceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author Chen
 * @Date 2020/6/10
 * @Time 09:20
 * @Annotate
 **/
@Configuration
public class DataSourceConfig {

    @Bean("datasource")
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource batcheDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("originDatasource")
    @ConfigurationProperties(prefix="spring.origin-datasource")
    public DataSource originDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("targetDatasource")
    @ConfigurationProperties(prefix="spring.target-datasource")
    public DataSource targetDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 自定义sqlManager
     * @return
     */
    @Bean
    public BeetlSqlMutipleSourceCustomize beetlSqlCustomize() {
        return (dataSource, sqlManager) -> {
            Interceptor[] interceptors = new Interceptor[1];
            interceptors[0] = new BeetlSqlDebugInterceptor();
            sqlManager.setInters(interceptors);
        };
    }

}
