package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询代理商政策设置范围响应体")
public class SelectAgentPolicyScopeBodyResVo {
    @ApiModelProperty(value = "最大激活金额", required = false, example = "")
    private int CST_ACTIVATION_PRICE_MAX;

    @ApiModelProperty(value = "最大90天金额", required = false, example = "")
    private int CST_90VIP_MAX;

    @ApiModelProperty(value = "最小150天金额", required = false, example = "")
    private int CST_150VIP_MIN;

    @ApiModelProperty(value = "最大活动金额", required = false, example = "")
    private int CST_ACTIVITY_PRICE_MAX;

    @ApiModelProperty(value = "最大交易费率", required = false, example = "")
    private int CST_RATE_MAX;

    @ApiModelProperty(value = "最小交易手续费", required = false, example = "")
    private int CST_FEE_MIN;

    @ApiModelProperty(value = "最小交易费率", required = false, example = "")
    private int CST_RATE_MIN;

    @ApiModelProperty(value = "最大交易手续费", required = false, example = "")
    private int CST_FEE_MAX;

    @ApiModelProperty(value = "最小活动金额", required = false, example = "")
    private int CST_ACTIVITY_PRICE_MIN;

    @ApiModelProperty(value = "最小激活金额", required = false, example = "")
    private int CST_ACTIVATION_PRICE_MIN;

    @ApiModelProperty(value = "最小90天金额", required = false, example = "")
    private int CST_90VIP_MIN;

    @ApiModelProperty(value = "最大150天金额", required = false, example = "")
    private int CST_150VIP_MAX;

}