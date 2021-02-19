package com.posp.oos.web.srv.model.vo.res.old;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.posp.oos.web.srv.model.vo.base.BaseHeadResVo;
import com.posp.oos.web.srv.model.vo.res.old.body.ReportBodyResVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "代理商报备响应")
public class ReportResVo {

    @JsonProperty("HEAD")
    @ApiModelProperty(value = "响应头", required = true)
    private BaseHeadResVo head;

    @JsonProperty("BODY")
    @ApiModelProperty(value = "响应体", required = true)
    private ReportBodyResVo body;

}