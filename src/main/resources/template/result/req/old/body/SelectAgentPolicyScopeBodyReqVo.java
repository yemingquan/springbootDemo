package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询代理商政策设置范围请求体")
public class SelectAgentPolicyScopeBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = "政策id", required = false, example = "")
    private int policyId;

    @ApiModelProperty(value = "主政策id", required = false, example = "")
    private int parentId;

}