package com.posp.oos.web.srv.model.vo.res.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询支行联行号响应体")
public class SubbranchListBodyResVo {
    @ApiModelProperty(value = "城市id", required = true, example = "")
    private int cityCode;

    @ApiModelProperty(value = "", required = false, example = "")
    private object?[]subBranchList;

    @ApiModelProperty(value = "支行名称", required = true, example = "")
    private int accbankNo;

    @ApiModelProperty(value = "联行号", required = true, example = "")
    private int paybankNo;

}