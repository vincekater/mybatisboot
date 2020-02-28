package com.szpnr.plsup.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtils  {
    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext applicationContext){
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return context;
    }


    public static Object getBean(String s) throws BeansException {
        return context.getBean(s);
    }


    public static <T> T getBean(Class<T> aClass) throws BeansException {
        return context.getBean(aClass);
    }
}
