package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "开启/关闭强扣请求体")
public class DoStrongBuckleBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = "政策id", required = false, example = "")
    private int policyId;

    @ApiModelProperty(value = "关闭打开（1:关闭 10:开启）", required = false, example = "")
    private int off_On;

    @ApiModelProperty(value = "1:激活返现，3:活动返现", required = false, example = "")
    private int type;

}