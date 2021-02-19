package com.example.springBootDemo.model;


import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "学生实体")
@TableName("biz_student")
public class Student2 {

    @JsonProperty("ID")
    @ApiModelProperty(value = "学生id", required = false, example = "99")
    @Max(value = 100, message = "学生id最大值不超过100")
    @TableId(value="id", type= IdType.AUTO)
    private Long id;


    @ApiModelProperty(value = "学生姓名", required = true, example = "werwr")
    @NotBlank(message = "姓名不允许为空,请输入")
    @JsonProperty("NAME")
    @TableField("name")
    private String name;

//    @ApiModelProperty(value = "学生性别", required = true, example = "werwr")
//    @NotBlank(message = "姓名不允许为空,请输入")
//    @JsonProperty("sex")
//    @TableField("sex")
//    private String sex;
}
