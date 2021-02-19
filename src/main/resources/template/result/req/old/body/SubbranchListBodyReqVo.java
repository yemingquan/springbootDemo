package com.posp.oos.web.srv.model.vo.req.old.body;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询支行联行号请求体")
public class SubbranchListBodyReqVo {
    @ApiModelProperty(value = "城市id", required = false, example = "")
    private String cityCode;

    @ApiModelProperty(value = "银行名称", required = false, example = "")
    private String bankName;

}