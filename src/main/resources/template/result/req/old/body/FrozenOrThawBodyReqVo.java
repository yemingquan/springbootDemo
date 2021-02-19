package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "代理商冻结/解冻请求体")
public class FrozenOrThawBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = "true 冻结整个链条 false：冻结单个", required = false, example = "")
    private boolean isHierarchy;

    @ApiModelProperty(value = "状态：（1：冻结，10：解冻）", required = false, example = "")
    private integer state;

}