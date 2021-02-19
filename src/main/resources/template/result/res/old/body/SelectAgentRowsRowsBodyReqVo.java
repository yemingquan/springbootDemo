package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询代理商列表响应体")
public class SelectAgentRowsRowsBodyReqVo {
    @ApiModelProperty(value = "冻结状态(1:正常;10:冻结;)", required = false, example = "")
    private int accountState;

    @ApiModelProperty(value = "代理商id", required = true, example = "")
    private int agentId;

    @ApiModelProperty(value = "身份证号", required = true, example = "")
    private String idCard;

    @ApiModelProperty(value = "电话", required = true, example = "")
    private String mobile;

    @ApiModelProperty(value = "上级抵扣参数id", required = false, example = "")
    private int pAgentDeductId;

    @ApiModelProperty(value = "总激活数", required = true, example = "")
    private int sumActivation;

    @ApiModelProperty(value = "代理商名称", required = true, example = "")
    private String agentName;

    @ApiModelProperty(value = "总库存终端数", required = true, example = "")
    private int sumSn;

    @ApiModelProperty(value = "总交易量", required = true, example = "")
    private int sumAmount;

    @ApiModelProperty(value = "代理商等级（1:总机构;2:子机构;3:1级代理商;4+代理商累加;）", required = true, example = "")
    private String agentLevel;

    @ApiModelProperty(value = "上级代理", required = true, example = "")
    private String parentName;

    @ApiModelProperty(value = "钱包余额", required = false, example = "")
    private int balance;

    @ApiModelProperty(value = "加入时间", required = true, example = "")
    private String createTime;

    @ApiModelProperty(value = "代理商层级", required = false, example = "")
    private int agentHierarchy;

    @ApiModelProperty(value = "货款余额", required = false, example = "")
    private int goodsBalance;

    @ApiModelProperty(value = "代理商状态（1:正常;10:禁止登录;11:止付;12:注销;）", required = true, example = "")
    private int state;

    @ApiModelProperty(value = "平台抵扣参数id", required = false, example = "")
    private int tAgentDeductId;

    @ApiModelProperty(value = "拓展渠道数", required = true, example = "")
    private int sumAgent;

    @ApiModelProperty(value = "邀请码", required = true, example = "")
    private String invitationCode;

}