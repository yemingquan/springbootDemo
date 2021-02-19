package com.example.springBootDemo.controller;

import com.example.springBootDemo.task.AsyncTasks;
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
 * @创建时间 2020/7/12 14:16
 * @备注
 */
@Slf4j
@Api(tags = {"task", "任务接口"})
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    AsyncTasks asyncTasks;

    @ApiOperation(value = "")
    @PostMapping(value = "task", name = "异步任务测试")
    public void taskTask() {
        asyncTasks.hello();
        log.info("taskTask end");
    }
}
