package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "修改代理商请求体")
public class UpdateAgentBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = true, example = "")
    private int agentId;

    @ApiModelProperty(value = "登陆用户名", required = false, example = "")
    private String agentUserName;

    @ApiModelProperty(value = "登陆账户", required = false, example = "")
    private String mobile;

    @ApiModelProperty(value = "营业执照名称", required = false, example = "")
    private String agentName;

    @ApiModelProperty(value = "开户行", required = false, example = "")
    private String bankName;

    @ApiModelProperty(value = "法人姓名", required = false, example = "")
    private String legalPersonName;

    @ApiModelProperty(value = "法人身份证", required = false, example = "")
    private String legalPersonCard;

    @ApiModelProperty(value = "卡号id", required = false, example = "")
    private String bankCardId;

    @ApiModelProperty(value = "(对公账户信息）户名", required = false, example = "")
    private String toPublicName;

    @ApiModelProperty(value = "账户属性，0对私，1对公", required = false, example = "")
    private int isPublicAcc;

    @ApiModelProperty(value = "注册号", required = false, example = "")
    private String registrationNumber;

    @ApiModelProperty(value = "所属分公司", required = false, example = "")
    private String parentFiliale;

    @ApiModelProperty(value = "开户账号", required = false, example = "")
    private String account;

    @ApiModelProperty(value = "支行联行号", required = false, example = "")
    private String paybankNo;

}