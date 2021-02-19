package com.example.springBootDemo.config.components.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @所属模块<p>
 * @描述
 * @Configuration用于定义配置类 拦截器配置类<p>
 * @创建人 xiaoYe
 * @创建时间 2021/1/15 16:44
 * @Copyright (c) 2020 inc. all rights reserved<p>
 * @公司名称
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    /**
     * 主要拦截器
     */
    @Autowired
    private AdminInterceptor adminInterceptor;
    /**
     * 业务拦截器
     */
    @Autowired
    private BusInterceptor busInterceptor;

    /**
     * 登录拦截器
     */
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        putAdminInterceptor(registry);
//        putLoginInterceptor(registry);
//        putBusInterceptor(registry);
    }


    /**
     * 主要拦截器注入
     *
     * @param registry
     */
    private void putAdminInterceptor(InterceptorRegistry registry) {
        /**
         - /**： 匹配所有路径
         - /admin/**：匹配 /admin/ 下的所有路径
         - /secure/*：只匹配 /secure/user，不匹配 /secure/user/info
         */
        registry.addInterceptor(adminInterceptor)
                //拦截配置
                .addPathPatterns("/**")
                //不拦截配置
                .excludePathPatterns(
                        //                "/student/list",           //登录
                        "/**/*.html",            //html静态资源
                        "/**/*.js",              //js静态资源
                        "/**/*.css",             //css静态资源
                        "/**/*.woff",           //其他资源
                        "/**/*.ttf");
    }

    /**
     * 登录拦截器
     *
     * @param registry
     */
    private void putLoginInterceptor(InterceptorRegistry registry) {
//      登录路径
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }

    /**
     * 业务拦截器注入
     *
     * @param registry
     */
    private void putBusInterceptor(InterceptorRegistry registry) {
//      业务路径
        registry.addInterceptor(busInterceptor).addPathPatterns("/**");
    }
}


/**
 * 注入方式区别
 * registry.addInterceptor(getInterfaceAuthCheckInterceptor()).addPathPatterns("/api/**");
 * 这种方式无论什么情况都可以
 * registry.addInterceptor(new InterfaceAuthCheckInterceptor()).addPathPatterns("/api/**");
 * 这种情况时，自定义的interceptor中不能注入其他内容，比如redis或者其他service，如果要注入，必须使用上面这种方法
 */