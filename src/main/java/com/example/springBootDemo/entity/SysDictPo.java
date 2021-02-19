package com.example.springBootDemo.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 字典表(SysDict)表实体类
 *
 * @author xiaoye
 * @since 2021-01-29 20:34:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "字典表")
@TableName("sys_dict")
public class SysDictPo implements Serializable {
         
    @ApiModelProperty(value = "id", required = false)
    private Long id;
         
    @ApiModelProperty(value = "字典类型", required = false)
    private String dictType;
         
    @ApiModelProperty(value = "字典类型名字", required = false)
    private String dictTypeName;
         
    @ApiModelProperty(value = "字典编码", required = false)
    private String dictCode;
         
    @ApiModelProperty(value = "字典名字", required = false)
    private String dictName;
         
    @ApiModelProperty(value = "父类字典类型", required = false)
    private String fDictType;
         
    @ApiModelProperty(value = "父类字典类型名字", required = false)
    private String fDictTypeName;
         
    @ApiModelProperty(value = "父类编码", required = false)
    private String fDictCode;
         
    @ApiModelProperty(value = "父类编码名字", required = false)
    private String fDictName;
         
    @ApiModelProperty(value = "序号", required = false)
    private Integer sort;
         
    @ApiModelProperty(value = "删除标记", required = false)
    private Integer delFalg;
         
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createTimme;
         
    @ApiModelProperty(value = "创建者", required = false)
    private String createBy;
         
    @ApiModelProperty(value = "修改时间", required = false)
    private Date updateTime;
         
    @ApiModelProperty(value = "修改者", required = false)
    private String updateBy;
         
    @ApiModelProperty(value = "备注", required = false)
    private String remark;


}