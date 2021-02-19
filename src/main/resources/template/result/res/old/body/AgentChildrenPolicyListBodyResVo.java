package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "根据父类政策查询代理商子政策政策列表响应体")
public class AgentChildrenPolicyListBodyResVo {
    @ApiModelProperty(value = "总页数", required = true, example = "")
    private int pageTotal;

    @ApiModelProperty(value = "总条数", required = true, example = "")
    private int total;

    @ApiModelProperty(value = "页码", required = true, example = "")
    private int page;

    @ApiModelProperty(required = true)
    private List<AgentChildrenPolicyListRowsBodyReqVo> rows;

}