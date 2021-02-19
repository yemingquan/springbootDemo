package com.example.springBootDemo.config.parameters.annotation;

import com.example.springBootDemo.config.parameters.constant.SystemConstant;

import java.lang.annotation.*;

/**
 * @所属模块 配置-注解-aop方法注解
 * @描述 方法注解，不要用到接口方法上
 * @创建人 xiaoYe
 * @创建时间 2020/5/1 11:48
 * @备注
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodAnnotation {
    /**
     * 方法名配置，不影响接口类
     *
     * @return
     */
    String methodName() default SystemConstant.DEFAULT_METHOD_NAME;

    /**
     * 是否在日志上打印参数
     *
     * @return
     */
    boolean printArgsFlag() default SystemConstant.DEFAULT_PRINT_METHOD_ARGS_FLAG;

    /**
     * 独立事物标志（一般接口默认开事物，这个事物标志用于独立开启单独的事物）
     *
     * @return
     */
    boolean transctionFlag() default SystemConstant.DEFAULT_TRANSCTION_FLAG;
}
