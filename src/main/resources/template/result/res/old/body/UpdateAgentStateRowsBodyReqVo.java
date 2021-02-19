package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "修改代理商状态响应体")
public class UpdateAgentStateRowsBodyReqVo {
    @ApiModelProperty(value = "分润参数强扣状态:1.关闭 10:开启", required = false, example = "")
    private int profitSharState;

    @ApiModelProperty(value = "vip90返现金额", required = true, example = "")
    private int vip90Price;

    @ApiModelProperty(value = "代理商id", required = true, example = "")
    private int agentId;

    @ApiModelProperty(value = "政策名称", required = true, example = "")
    private String policyName;

    @ApiModelProperty(value = "激活返现强扣状态 1.关闭 10.开启", required = false, example = "")
    private int activatiState;

    @ApiModelProperty(value = "活动返现强扣金额", required = false, example = "")
    private int activityForce;

    @ApiModelProperty(value = "成长期结算价", required = false, example = "")
    private int growthRate;

    @ApiModelProperty(value = "商户交易费率", required = true, example = "")
    private int txnRate;

    @ApiModelProperty(value = "代理商名称", required = true, example = "")
    private String agentName;

    @ApiModelProperty(value = "分润参数强扣比例", required = false, example = "")
    private String profitSharForce;

    @ApiModelProperty(value = "激活返现强扣金额", required = false, example = "")
    private int activatiForce;

    @ApiModelProperty(value = "结算手续费", required = true, example = "")
    private int agentFee;

    @ApiModelProperty(value = "活动返现金额", required = true, example = "")
    private int activityPrice;

    @ApiModelProperty(value = "政策id", required = true, example = "")
    private int policyId;

    @ApiModelProperty(value = "激活返现金额", required = true, example = "")
    private int activationPrice;

    @ApiModelProperty(value = "活动返现强扣状态 1.关闭 10.开启", required = false, example = "")
    private int activityState;

    @ApiModelProperty(value = "vip150返现金额", required = true, example = "")
    private int vip150Price;

    @ApiModelProperty(value = "商户交易手续费", required = true, example = "")
    private int txnFee;

    @ApiModelProperty(value = "结算费率", required = true, example = "")
    private int agentRate;

}