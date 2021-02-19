package com.example.springBootDemo.config.parameters.enums;

import java.util.Arrays;

/**
 * TODO 无法定义为常量
 */
public enum ApiEnum {
    api("sdf");

    /**
     * 描述
     */
    private String desc;


    ApiEnum(String desc) {

        this.desc = desc;
    }

    public static String getDesc(String name) {
        return Arrays.asList(values()).stream().filter(e -> e.name().equals(name)).findFirst().get().desc;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }
}
