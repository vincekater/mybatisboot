package com.szpnr.plsup;


import com.szpnr.plsup.mybatis.dao.PlsupLocationMapper;
import com.szpnr.plsup.mybatis.model.PlsupLocation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
//@ComponentScan(value = "com.szpnr.plsup")
@MapperScan("com.szpnr.plsup.mybatis.dao")
public class PlsupApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(PlsupApplication.class);
    }

//    @Autowired
//    static PlsupLocationMapper dao;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PlsupApplication.class,args);
//        System.out.println(context.getBean(PlsupLocationMapper.class));
//        dao = context.getBean("dao",PlsupLocationMapper.class);
//        PlsupLocation location = dao.selectByPrimaryKey(Short.parseShort("1"));
//        System.out.println(location);
    }
}
