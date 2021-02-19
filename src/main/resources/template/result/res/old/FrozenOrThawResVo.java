package com.posp.oos.web.srv.model.vo.res.old;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.posp.oos.web.srv.model.vo.base.BaseHeadResVo;
import com.posp.oos.web.srv.model.vo.res.old.body.FrozenOrThawBodyResVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "代理商冻结/解冻响应")
public class FrozenOrThawResVo {

    @JsonProperty("HEAD")
    @ApiModelProperty(value = "响应头", required = true)
    private BaseHeadResVo head;

    @JsonProperty("BODY")
    @ApiModelProperty(value = "响应体", required = true)
    private FrozenOrThawBodyResVo body;

}