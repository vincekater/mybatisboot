package com.szpnr.plsup;



import com.szpnr.plsup.common.utils.SpringContextUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@ComponentScan(basePackages ={"com.szpnr.plsup.*"})
@MapperScan("com.szpnr.plsup.*.mapper,com.szpnr.plsup.*.*.mapper")//多个用,号分隔
@ServletComponentScan(basePackages={"com.szpnr.plsup.*"})//用于WebFilter的注入
//@ServletComponentScan("{com.szpnr.plsup.base,com.szpnr.plsup.common}")
public class PlsupApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(PlsupApplication.class);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PlsupApplication.class,args);
        SpringContextUtils.setApplicationContext(context);

    }
}
