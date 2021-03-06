package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "修改代理商状态响应体")
public class UpdateAgentStateBodyResVo {
    @ApiModelProperty(value = "总页数", required = true, example = "")
    private int pageTotal;

    @ApiModelProperty(value = "总条数", required = true, example = "")
    private int total;

    @ApiModelProperty(value = "页码", required = true, example = "")
    private int page;

    @ApiModelProperty(required = true)
    private List<UpdateAgentStateRowsBodyReqVo> rows;

}