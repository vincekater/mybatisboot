package com.szpnr.plsup.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.filters}")
    private String filters;


    @Bean
    @Primary
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        return druidDataSource;
    }


    /**
     * mybatis plus page分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * mybatis plus page分页插件，打印sql语句
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        Properties properties = new Properties();
        properties.setProperty("format","false");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }

    /**
     * 主键使用
     *create sequence SEQ_PLSUP_DEFAULT minvalue 2211000000 maxvalue 9999999999999999 start with 2211000000 increment by 1 nocache;
     *keyGenerator: com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator
     * @return
     */
    @Bean
    public OracleKeyGenerator oracleKeyGenerator(){
        return new OracleKeyGenerator();
    }

}
