package com.example.springBootDemo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/7/12 14:15
 * @备注
 */
@Component
@Slf4j
public class AsyncTasks {

    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中.....");
    }
}
