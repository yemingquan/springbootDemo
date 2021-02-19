package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询政策响应体")
public class PolicyBodyResVo {
    @ApiModelProperty(required = false)
    private List<PolicyRowsBodyReqVo> rows;

}