package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "重置密码请求体")
public class ResetAgentPasswordBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = "类型：1：普通商户；2：代理商商户（此处为代理商重置密码所以类型为2）", required = false, example = "")
    private integer type;

}