package com.example.springBootDemo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.example.springBootDemo.entity.SysDictPo;
import com.example.springBootDemo.service.SysDictService;

/**
 * 字典表(SysDict)表控制层
 *
 * @author xiaoye
 * @since 2021-01-29 20:05:55
 */
@Slf4j
@RestController
@RequestMapping("sysDict")
@Api(tags = {"SysDict", "字典表"})
public class SysDictController {
    /**
     * 服务对象
     */
    @Autowired
    private SysDictService sysDictService;

    /**
     * 新增字典表
     *
     * @param po 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping(name = "新增字典表", value = "insert")
    public void insert(@Valid @RequestBody SysDictPo po) throws Exception {
        sysDictService.insert(po);
    }

}