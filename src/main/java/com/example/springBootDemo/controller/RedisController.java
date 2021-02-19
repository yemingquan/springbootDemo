//package com.example.springBootDemo.controller;
//
//import com.example.springBootDemo.config.components.redis.RedisUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @所属模块<p>
// * @描述<p>
// * @创建人 xiaoYe
// * @创建时间 2021/2/4 15:41
// * @Copyright (c) 2020 inc. all rights reserved<p>
// * @公司名称
// */
//@Slf4j
//@RestController
//@Api(tags = {"redis测试"})
//@RequestMapping("redis")
//public class RedisController {
//
////    @Autowired
////    TestService testService;
//
//    @Autowired
//    private RedisUtil redisUtils;
//
//    @PostMapping(value = "/initDict/{id}")
//    @ApiOperation(value = "字典初始化")
//    public String hello(@PathVariable(value = "id") String id) {
//        //查询缓存中是否存在
//        boolean hasKey = redisUtils.hasKey(id);
//        String str = "";
//        if (hasKey) {
//            //获取缓存
//            Object object = redisUtils.get(id);
//            log.info("从缓存获取的数据" + object);
//            str = object.toString();
//        } else {
////            //从数据库中获取信息
////            log.info("从数据库中获取数据");
////            str = testService.test();
////            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
////            redisUtils.set(id,str,10L,TimeUnit.MINUTES);
////            log.info("数据插入缓存" + str);
//        }
//        return str;
//    }
//}
