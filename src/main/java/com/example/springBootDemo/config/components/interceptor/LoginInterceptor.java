package com.example.springBootDemo.config.components.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @所属模块<p>
 * @描述 登录拦截器<p>
 * @创建人 xiaoYe
 * @创建时间 2021/1/15 17:49
 * @Copyright (c) 2020 inc. all rights reserved<p>
 * @公司名称
 */
@Slf4j
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginInterceptor preHandle");
//        try {
////            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
////            User user=(User)request.getSession().getAttribute("USER");
////            if(user!=null){
////                return true;
////            }
////            response.sendRedirect(request.getContextPath()+"你的登陆页地址");
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
