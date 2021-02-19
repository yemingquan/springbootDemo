package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "修改抵扣参数请求体")
public class AgentdeductionRationBodyReqVo {
    @ApiModelProperty(value = "VIP返现抵扣比例", required = false, example = "")
    private String vipRate;

    @ApiModelProperty(value = "被设置的代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = ""抵扣类型（抵扣类型：1对平台", required = false, example = "")
            private int deductType;

            @ApiModelProperty(value = "交易分润抵扣比例", required = false, example = "")
            private String txnRate;

            @ApiModelProperty(value = "激活返现抵扣比例", required = false, example = "")
            private String activationRate;

            @ApiModelProperty(value = "活动返现抵扣比例", required = false, example = "")
            private String activityRate;
}