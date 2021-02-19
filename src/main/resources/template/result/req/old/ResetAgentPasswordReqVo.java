package com.posp.oos.web.srv.model.vo.req.old;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.posp.oos.web.srv.model.vo.base.BaseHeadReqVo;
import com.posp.oos.web.srv.model.vo.req.old.body.ResetAgentPasswordBodyReqVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "重置密码请求")
public class ResetAgentPasswordReqVo {

    @JsonProperty("HEAD")
    @ApiModelProperty(value = "请求头", required = true)
    private BaseHeadReqVo head;

    @JsonProperty("BODY")
    @ApiModelProperty(value = "请求体", required = true)
    private ResetAgentPasswordBodyReqVo body;

}