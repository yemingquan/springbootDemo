package com.example.springBootDemo.config.components.system;

import com.example.springBootDemo.config.parameters.constant.SystemConstant;
import com.example.springBootDemo.util.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


/**
 * @所属模块 配置-初始化设置
 * @描述 <p>在程序初始时，继承该接口的类，在初始化bean的时候都会执行该方法。般用于在系统初始化时，<p>
 * <p> 为系统提供一些初始信息</p>
 * @创建人 xiaoYe
 * @创建时间 2020/4/7 23:39
 * @备注
 */
@Slf4j
@Component
public class SystemInitConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("打印项目初始化信息！");
        log.info("本机IP:[{}]", SystemUtil.getIpAddress());
        log.info("类路径：[{}]", SystemUtil.getClassPath());
        SystemUtil.showSystemInfo();
    }
}
