package com.example.springBootDemo.config.parameters.annotation;

import java.lang.annotation.*;

/**
 * @所属模块 配置-注解-事物注解
 * @描述 TODO 动态打印sql语句 未实现
 * @创建人 xiaoYe
 * @创建时间 2020/5/1 11:48
 * @备注
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SqlAnnotation {
    boolean printSqlFlag() default false;

    //由系统配置改属性
    String printMethodName() default "";
}
