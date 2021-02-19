package com.example.springBootDemo.config.components.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @所属模块<p>
 * @描述
 * 顺序：过滤前-拦截前-action执行-拦截后-过滤后
 * 功能：主要拦截器，用于
 * 1.报文加密
 * 2.报文时间有效性校验
 * 3.编码处理
<p>
 * @创建人 xiaoYe
 * @创建时间 2021/1/15 16:34
 * @Copyright (c) 2020 inc. all rights reserved<p>
 * @公司名称
 */
@Slf4j
@Configuration
public class AdminInterceptor implements HandlerInterceptor {
    /**
     * 前置处理
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果设置为true时，请求将会继续执行后面的操作
        /*1.报文加密
        2.报文时间有效性校验
        3.编码处理
        */

        log.info("preHandle");
   
        return true;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作

    }

    /**
     * 方法处理之后处理
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    /**
     * 请求结束后处理
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
