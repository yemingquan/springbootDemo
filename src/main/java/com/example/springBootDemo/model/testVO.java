package com.example.springBootDemo.model;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @所属模块<p>
 * @描述<p>
 * @创建人 xiaoYe
 * @创建时间 2020/9/25 16:42
 * @Copyright (c) 2020 inc. all rights reserved<p>
 * @公司名称 xxx公司
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "")
@TableName("")
public class testVO {

    /**
     * name : Howl
     * nickname : Howlet
     * array : ["firstname","lastname"]
     * complex : [{"java":"good"},{"php":"bad"}]
     */

    private String name;
    private String nickname;
    private List<String> array;
    private List<ComplexBean> complex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getArray() {
        return array;
    }

    public void setArray(List<String> array) {
        this.array = array;
    }

    public List<ComplexBean> getComplex() {
        return complex;
    }

    public void setComplex(List<ComplexBean> complex) {
        this.complex = complex;
    }

    public static class ComplexBean {
        /**
         * java : good
         * php : bad
         */

        private String java;
        private String php;

        public String getJava() {
            return java;
        }

        public void setJava(String java) {
            this.java = java;
        }

        public String getPhp() {
            return php;
        }

        public void setPhp(String php) {
            this.php = php;
        }
    }
}
