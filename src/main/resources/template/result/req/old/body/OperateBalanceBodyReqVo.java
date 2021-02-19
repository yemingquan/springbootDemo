package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "代理商（手动更改代理商的钱）请求体")
public class OperateBalanceBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = "操作金额", required = false, example = "")
    private int amount;

    @ApiModelProperty(value = "流水描述", required = false, example = "")
    private String record;

    @ApiModelProperty(value = "签钥", required = false, example = "")
    private String sign;

    @ApiModelProperty(value = "类型（1：新增余额；10：减少余额）", required = false, example = "")
    private integer type;

}