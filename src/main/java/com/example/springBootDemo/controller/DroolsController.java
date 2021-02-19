package com.example.springBootDemo.controller;

import com.example.springBootDemo.model.Address;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/6/2 14:36
 * @备注
 */
@Slf4j
@RestController
@RequestMapping("drools")
@Api(tags = {"drools", "DROOLS学习"})
public class DroolsController {
    @Autowired
    private KieSession kieSession;

    @ApiOperation(value = "")
    @ApiImplicitParam(name = "postCode", required = true, defaultValue = "323000")
    @PostMapping(value = "DROOLS_001", name = "通过drools校验邮政编码")
    public void checkAddress(String postCode) {
        Address address = new Address();
        address.setPostCode(postCode);

        // 使用规则引擎
        kieSession.insert(address);
//      命中规则，则有then为返回值
        int ruleFiredCount = kieSession.fireAllRules();
        log.info("触发了[{}]条规则",ruleFiredCount);
        log.info("---------------------------------");
    }
}
