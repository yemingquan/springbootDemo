package com.example.springBootDemo.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ExcelTarget("Student")
@ApiModel(description = "学生实体")
@TableName("biz_student")
public class Student implements Serializable {


    @JsonProperty("ID")
    @ApiModelProperty(value = "学生id", required = true, example = "99")
//    @Max(value = 100, message = "学生id最大值不超过100")
    @Excel(name = "学生id", orderNum = "0")
    @TableId(value="id", type= IdType.AUTO)
    private Long id;



    @ApiModelProperty(value = "学生姓名", required = true, example = "werwr")
    @NotBlank(message = "姓名不允许为空,请输入")
    @JsonProperty("NAME")
    @Excel(name = "学生姓名", orderNum = "1")
    private String name;
}
