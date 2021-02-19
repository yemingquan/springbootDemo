package com.example.springBootDemo.controller;

import com.example.springBootDemo.config.parameters.constant.ApiConstant;
import com.example.springBootDemo.config.components.error.BizException;
import com.example.springBootDemo.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @所属模块
 * @描述 批量插入测试
 * @创建人 xiaoYe
 * @创建时间 2020/5/4 16:59
 * @备注
 */
@Slf4j
@RestController
@RequestMapping("student")
@Api(tags = {"student", "用Student数据测试批量插入"})
public class BatchTestController {

    @Autowired
    IStudentService service;

    @ApiOperation(value = "清空数据后批量插入")
    @ApiImplicitParam(name = "count", required = true, defaultValue = "30")
    @PostMapping(value = ApiConstant.API_BATCH_SAVE, name = ApiConstant.DESC_BATCH_SAVE)
    public void batchSaveBean(int count) throws Exception {
//        if (true) throw new BizException("这里有个异常！！！！！");
//        if (false) {
//            int aaa = 1 / 0;
//        }
        service.truncate();
        service.batchSave(count);
    }


}
