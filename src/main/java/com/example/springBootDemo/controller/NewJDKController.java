package com.example.springBootDemo.controller;

import com.example.springBootDemo.model.Student;
import com.example.springBootDemo.model.Student2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/7/18 19:42
 * @备注
 */
@Slf4j
@RestController
@Api(tags={"JDK1.8"})
@RequestMapping("JDK")
public class NewJDKController {

    /**
     * 注解的测试
     *
     * @return
     */
    @ApiOperation(value = "stream练习", notes = "")
    @PostMapping("/stream")
    public void stream() throws Exception {

    }
}
