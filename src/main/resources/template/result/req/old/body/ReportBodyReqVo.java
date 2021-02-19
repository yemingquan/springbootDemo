package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "代理商报备请求体")
public class ReportBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = true, example = "")
    private int agentId;

}