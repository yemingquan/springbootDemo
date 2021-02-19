package com.example.springBootDemo.config.parameters.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @所属模块
 * @描述 TODO 暂时不用了，还不如常量类呢
 * @创建人 xiaoYe
 * @创建时间 2020/5/2 23:20
 * @备注
 */
public class ImportMapper {
    public static final Map<String, String> importMap;

    static {
        importMap = new HashMap<String, String>();
        importMap.put("@JsonProperty(","import com.fasterxml.jackson.annotation.JsonProperty;\n");
        importMap.put("@ApiModel(","import io.swagger.annotations.ApiModel;\n");
        importMap.put("@ApiModelProperty(","import io.swagger.annotations.ApiModelProperty;\n");
        importMap.put("@Api(","import io.swagger.annotations.Api;\n");
        importMap.put("@Data","import lombok.Data;\n");
        importMap.put("@NotBlank(","import org.hibernate.validator.constraints.NotBlank;\n");
        importMap.put("@Slf4j","import lombok.extern.slf4j.Slf4j;\n");
        importMap.put("@ApiImplicitParam(","import io.swagger.annotations.ApiImplicitParam;\n");
        importMap.put("@ApiOperation(","import io.swagger.annotations.ApiOperation;\n");

        importMap.put("@Autowired","import org.springframework.beans.factory.annotation.Autowired;\n");
        importMap.put("@PostMapping(","import org.springframework.web.bind.annotation.PostMapping;\n");
        importMap.put("@RestController","import org.springframework.web.bind.annotation.RestController;\n");
        importMap.put("@RequestMapping(","import org.springframework.web.bind.annotation.RequestMapping;\n");
        importMap.put("@Service","import org.springframework.stereotype.Service;\n");
        importMap.put("@Valid","import javax.validation.Valid;\n");
        importMap.put("@RequestBody","import org.springframework.web.bind.annotation.RequestBody;\n");

        importMap.put("@MethodAnnotation","import com.example.springBootDemo.config.parameters.annotation.MethodAnnotation;\n\n");

        importMap.put(" Map ","import java.util.Map;\n");

    }
}
