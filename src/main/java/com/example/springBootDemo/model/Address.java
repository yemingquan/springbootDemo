package com.example.springBootDemo.model;

import lombok.Data;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/6/2 14:35
 * @备注
 */
@Data
public class Address {
    private String postCode;
    public final String street = "a";
    private String state;

//    {
//        street = "b";
//    }

    public static String showStreet(){
        return "showStreet";
    }

}
