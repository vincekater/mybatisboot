package com.szpnr.plsup.config;

import com.szpl.platform.security.filter.MyauthenticatingFilter;
import com.szpl.platform.security.login.ExtendServiceImpl;
import com.szpl.platform.security.login.Shirorealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

//@Configuration //测试时需要注释掉
public class SsoConfig {
    //@Bean
    public MyauthenticatingFilter authc() {
        return new MyauthenticatingFilter();
    }

    //@Bean
   // @Autowired
    public Shirorealm shiroRealm(EhCacheManager ehCacheManager) {
        Shirorealm realm = new Shirorealm();
        realm.setCacheManager(ehCacheManager);
        realm.setSsoproject("plsup");
        return realm;
    }

    //@Bean
    public ExtendServiceImpl extendServiceImpl(){
        return new ExtendServiceImpl();
    }

   // @Bean()
    public EhCacheManager cacheManager() {
        EhCacheManager manager = new EhCacheManager();
        manager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return manager;
    }

   // @Bean
   // @Autowired
    public DefaultWebSecurityManager securityManager(Shirorealm shirorealm, EhCacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setCacheManager(cacheManager);
        securityManager.setRealm(shirorealm);
        return securityManager;
    }

    //@Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //@Bean
   // @Autowired
    public MethodInvokingFactoryBean mfb(DefaultWebSecurityManager securityManager) {
        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        bean.setArguments(new Object[]{securityManager});
        return bean;
    }

   // @Bean
   // @Autowired
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager,MyauthenticatingFilter authc) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/#/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/#/login");
        Map<String, Filter> map = new HashMap<>();
        map.put("authc",authc);
        //配置不校验登录权限的filters
        AnonymousFilter anon = new AnonymousFilter();
        map.put("anon",anon);
        shiroFilterFactoryBean.setFilters(map);
        //配置链接是否需要登录
        //示例  /static = anon 不登录  /userdetp = authc 需要登录认证
        shiroFilterFactoryBean.setFilterChainDefinitions("/static/** = anon\r\n" +
                "/static/js/** = anon\r\n" +
                "/static/layer/** = anon\r\n"+
                "/static/img/** = anon\r\n"+
                "/static/css/** = anon\r\n"+
                "/static/fonts/** = anon\r\n"+
                "/static/weboffice/** = anon\r\n"+
                "/#/login = anon\r\n" +
                "/login = anon\r\n" +
                "/login2 = anon\r\n" +
                "/index.html = anon\r\n" +
                "/map.html = anon\r\n" +
                "/kaptcha = anon\r\n" +
                "/hyzf_upload/** = anon\r\n" +
                "/** = authc");
        shiroFilterFactoryBean.getUnauthorizedUrl();
        return shiroFilterFactoryBean;
    }
}
