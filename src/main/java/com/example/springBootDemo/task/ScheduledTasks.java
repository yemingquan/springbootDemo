package com.example.springBootDemo.task;

import com.example.springBootDemo.service.IStudentService;
import com.example.springBootDemo.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @所属模块
 * @描述<p>
 *      @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
 *      @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
 *      @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 *      @Scheduled(cron=” /5 “) ：通过cron表达式定义规则，什么是cro表达式，自行搜索引擎。
 * </>
 * @创建人 xiaoYe
 * @创建时间 2020/7/12 14:02
 * @备注
 */
@Component
@Slf4j
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    IStudentService service;

    @Scheduled(fixedRate = 1*1000*60*60*24)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "* 0/10 * * * ?")
    public void doSomething() throws Exception {
        Thread.sleep(10*1000);
        log.info("每?秒执行一个的定时任务：[{}]", DateUtil.defaultDate.format(new Date()));
    }


}