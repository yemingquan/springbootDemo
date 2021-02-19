package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询代理商列表请求体")
public class SelectAgentRowsBodyReqVo {
    @ApiModelProperty(value = "代理商id", required = false, example = "")
    private int agentId;

    @ApiModelProperty(value = "代理商编号", required = false, example = "")
    private String agentNo;

    @ApiModelProperty(value = "手机号", required = false, example = "")
    private String mobile;

    @ApiModelProperty(value = "上级代理商id(上级机构、推荐树)", required = false, example = "")
    private int parentAgentId;

    @ApiModelProperty(value = "虚拟层级", required = false, example = "")
    private int agentHierarchy;

    @ApiModelProperty(value = "页面显示条数", required = true, example = "")
    private String pageSize;

    @ApiModelProperty(value = "当前页", required = true, example = "")
    private String currentPage;

    @ApiModelProperty(value = "代理商等级（1:机构;2:子机构;3:1级代理商;4+代理商累加;）", required = true, example = "")
    private int agentLevel;

}