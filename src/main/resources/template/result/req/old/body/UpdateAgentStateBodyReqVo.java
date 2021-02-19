package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "修改代理商状态请求体")
public class UpdateAgentStateBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = "政策id", required = false, example = "")
    private int policyId;

    @ApiModelProperty(value = "一页几条", required = false, example = "")
    private int pageSize;

    @ApiModelProperty(value = "当前页", required = false, example = "")
    private int currentPage;

    @ApiModelProperty(value = "父类政策id（默认0）", required = false, example = "")
    private int parentId;

}