package com.posp.oos.web.srv.model.vo.req.old;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.posp.oos.web.srv.model.vo.base.BaseHeadReqVo;
import com.posp.oos.web.srv.model.vo.req.old.body.OperateBalanceBodyReqVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "代理商（手动更改代理商的钱）请求")
public class OperateBalanceReqVo {

    @JsonProperty("HEAD")
    @ApiModelProperty(value = "请求头", required = true)
    private BaseHeadReqVo head;

    @JsonProperty("BODY")
    @ApiModelProperty(value = "请求体", required = true)
    private OperateBalanceBodyReqVo body;

}