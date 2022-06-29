package com.javaclimb.sickbed.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* 权限配置类
* */
@Configuration
public class ShiroFilterConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //shiro内置过滤器，实现权限相关的拦截器
        //static文件夹下无须权限即可访问
        //anon:无须登录既可访问  authc：登陆才可访问
        Map<String,String> filerMap = new LinkedHashMap<>();
        filerMap.put("/static/**","anon");
        filerMap.put("/login","anon");
        filerMap.put("/tologin","anon");
        filerMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filerMap);
        //没有登陆时自动转向的页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登陆后自动转向的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        return shiroFilterFactoryBean;
    }


    /*
    * 权限管理
    * */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /*
    * thymeleaf整合shiro
    * */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
