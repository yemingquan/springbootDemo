package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询政策响应体")
public class PolicyRowsBodyReqVo {
    @ApiModelProperty(value = "政策id", required = false, example = "")
    private String policyId;

    @ApiModelProperty(value = "政策名称", required = false, example = "")
    private String name;

}