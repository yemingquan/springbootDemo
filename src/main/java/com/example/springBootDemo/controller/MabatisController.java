package com.example.springBootDemo.controller;

import com.example.springBootDemo.config.parameters.annotation.MethodAnnotation;
import com.example.springBootDemo.model.Student2;
import com.example.springBootDemo.service.IStudent3Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/7/16 22:09
 * @备注
 */
@Slf4j
@Api(tags = {"student", "mabatisplus学生测试接口"})
@RestController
@RequestMapping("mabatisPlus")
public class MabatisController {
    @Autowired
    IStudent3Service student3Service;

    @ApiOperation(value = "mabatisplus学生新增")
    @PostMapping("/add")
    @MethodAnnotation(methodName = "新增学生")
    public void save(@Valid @RequestBody Student2 stu) {
        student3Service.insert(stu);
    }
}
