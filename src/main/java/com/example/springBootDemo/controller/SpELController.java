package com.example.springBootDemo.controller;

import com.example.springBootDemo.model.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @所属模块
 * @描述 SpEL测试
 * @创建人 xiaoYe
 * @创建时间 2020/6/2 22:12
 * @备注
 */
@Slf4j
@RestController
@RequestMapping("SpEL")
@Api(tags = {"SpEL", "SpEL学习"})
public class SpELController {

    @Bean
    public Address getAddress() {
        Address address = new Address();
//        address.setStreet("c");
        return address;
    }

    @Value("${server.port}")
    private String port;

    @Value("${server.port.a:#{'aaa'}}")
    private String portDeF;

    @Value("#{'${server.port}'.substring('0','1')+'qqqqq'}")
    private String portAddOther;

//    @Value("#{address.postCode}")
//    private String beanField;
//
//    @Value("#{address.showStreet()}")
////    @Value("#{'${oos.operationRole}'.split(',')}")
//    private String beanMethod;
//
//    @Value("#{com.example.springBootDemo.util.StringBuilderUtil.getGenMessageNameByAPIName('${oos.operationRole}')}")
//    private String staticBeanField;


    @ApiOperation(value = "")
    @PostMapping(value = "SPEL_001", name = "SpEL学习")
    public void checkAddress() {

        log.info("port[{}]",port);
        log.info("portAddOther[{}]",portAddOther);
        log.info("portDeF[{}]",portDeF);
//        log.info("beanField[{}]", beanField);
//        log.info("beanMethod[{}]",beanMethod);
//        log.info("staticBeanField[{}]",staticBeanField);
    }
}
