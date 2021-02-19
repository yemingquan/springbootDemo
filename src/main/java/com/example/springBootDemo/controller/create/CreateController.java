package com.example.springBootDemo.controller.create;

import com.example.springBootDemo.config.parameters.constant.ApiConstant;
import com.example.springBootDemo.service.create.ICreateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/6/9 10:05
 * @备注
 */
@Slf4j
@RestController
@RequestMapping("CREATE")
@Api(tags = {"创建代码", "根据模板文件创建代码"})
public class CreateController {

    @Autowired
    ICreateService createService;

//  TODO 需要至少两个配置文件 会返回一个压缩包 2020-6-9
//  TODO 可以考虑搞个 直接根据数据库指定表结构生成单表查询的服务 2020-6-9
    @ApiOperation(value = "创建代码，面向对外服务")
//    @ApiImplicitParam(name = "count", required = true, defaultValue = "30")
    @PostMapping(value = ApiConstant.API_CREATE, name = ApiConstant.DESC_CREATE)
    public void createFile() throws Exception {
        createService.createFile();
    }
}
