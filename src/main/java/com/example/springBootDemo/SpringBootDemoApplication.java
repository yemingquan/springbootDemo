package com.example.springBootDemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/*@MapperScan({"com.example.springBootDemo.dao"
     ,"com.example.springBootDemo.service","com.example.springBootDemo.controller","com.example.springBootDemo.model"})*/
/*@EnableAutoConfiguration
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})*/
//@RestController
// @ComponentScan(basePackages = {"com.example.springBootDemo.*"})
//@WebAppConfiguration
@Slf4j
@SpringBootApplication//项目启动
@EnableTransactionManagement//开启事物
@EnableScheduling//同步任务
@EnableAsync//异步任务
@MapperScan("com.example.springBootDemo.dao")//扫描dao/mapper层接口
public class SpringBootDemoApplication {


    //	@RequestMapping
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println("hello world!");

        SpringApplication.run(SpringBootDemoApplication.class, args);

//        spring环境包测试
//        Environment env = SpringContextUtil.getBean(Environment.class);
//        log.info(env.getProperty("server.port"));
        log.info("success!");

//          泛型测试
//        Student beanTest = new Student();
//        beanTest.setId(1l);
//        Student s = tell(beanTest);
    }

    public static <T> T tell(T t) {
        log.info("泛型测试[{}]", t.toString());
//        PageInfo<t> page = new PageInfo<>(t);
        return t;
    }
}
