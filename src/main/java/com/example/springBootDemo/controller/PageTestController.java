package com.example.springBootDemo.controller;

import com.example.springBootDemo.config.parameters.constant.ApiConstant;
import com.example.springBootDemo.model.Student;
import com.example.springBootDemo.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @所属模块
 * @描述 分页测试
 * @创建人 xiaoYe
 * @创建时间 2020/5/4 16:59
 * @备注
 */
@Slf4j
@RestController
@RequestMapping("student")
@Api(tags = {"student", "用Student数据测试分页"})
public class PageTestController {

    @Autowired
    IStudentService service;

    @ApiOperation(value = "学生分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", defaultValue = "2", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示个数", defaultValue = "10", required = true)
    })
    @PostMapping(value = ApiConstant.API_PAGE_TEST, name = ApiConstant.DESC_PAGE_TEST)
    public PageInfo<Student> list(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> allUsers = service.list();
        PageInfo<Student> pageInfo = new PageInfo<>(allUsers);
        return pageInfo;
    }
}
