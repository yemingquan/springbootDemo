package com.example.springBootDemo.config.parameters.constant;

/**
 * @所属模块 配置-参数-系统常量
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/5/2 23:02
 * @备注
 */
public class SystemConstant {
//    TODO 当前系统信息
//    TODO 系统监控（监督异常与性能）
//    TODO 用户信息
    /**
     * 打印方法(不包括接口方法,控制范围由AOP和该标志共同决定)入参标记
     */
    public static final boolean DEFAULT_PRINT_METHOD_ARGS_FLAG = true;
    /**
     * 方法注解默认方法名
     */
    public static final String DEFAULT_METHOD_NAME = "未定义方法名";
    /**
     * 是否默认开启事物
     */
    public static final boolean DEFAULT_TRANSCTION_FLAG = false;

    /**
     * 统一文件编码
     */
    public static final String DEFAULT_FILE_CHARSETNAME = "UTF-8";
    /**
     * TODO ？
     */
    public static final String DEFAULT_CSV_SPLITY_REGEX = ",";
    /**
     * 默认时间格式
     */
    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认时区配置
     */
    public static final String DEFAULT_TIME_ZONE = "GMT+8";
}
