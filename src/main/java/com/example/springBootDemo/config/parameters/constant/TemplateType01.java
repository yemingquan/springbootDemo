package com.example.springBootDemo.config.parameters.constant;

/**
 * @所属模块 配置-参数-自动生成业务常量
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/5/17 9:18
 * @备注
 */
public class TemplateType01 {

    /**
     * 名字后缀
     */
    public static final String TYPE01_CONFIG_CLASS_NAME_SUFFEX = "Constant";
    public static final String TYPE01_REQ_HEAD_CLASS_NAME_SUFFEX = "";
    public static final String TYPE01_RES_HEAD_CLASS_NAME_SUFFEX = "";

    public static final String TYPE01_ACTION_CLASS_NAME_SUFFEX = "Controller";
    public static final String TYPE01_SERVICE_INTERFACE_CLASS_NAME_SUFFEX = "Service";
    public static final String TYPE01_SERVICE_CLASS_NAME_SUFFEX = "Service";
    public static final String TYPE01_REQ_CLASS_NAME_SUFFEX = "Req";
    public static final String TYPE01_REQ_BODY_CLASS_NAME_SUFFEX = "ReqBody";
    public static final String TYPE01_RES_CLASS_NAME_SUFFEX = "Res";
    public static final String TYPE01_RES_BODY_CLASS_NAME_SUFFEX = "ResBody";

    /**
     * ActionMap存放主要信息
     */
    public static final String TYPE01_ACTION_API_NAME = "";
    public static final String TYPE01_ACTION_API_CHINESE_NAME = "";

    public static final String TYPE01_ACTION_CHINESE_NAME = "";
    public static final String TYPE01_ACTION_METHOD_NAME = "";

    /**
     * packagePathTemplate com.example.springBootDemo.controller
     */
    public static final String TYPE01_PACKAGE_PATH_PREFIX = "package ";
    public static final String TYPE01_ACTION_PACKAGE_PATH_SUFFIX = "^projectPath$.controller;\n";
    public static final String TYPE01_CONFIG_PACKAGE_PATH_SUFFIX = "^projectPath$.config;\n";

    public static final String TYPE01_REQ_BODY_PACKAGE_PATH_SUFFIX = "^projectPath$.model.req.body;\n";
    public static final String TYPE01_REQ_HEAD_PACKAGE_PATH_SUFFIX = "^projectPath$.model.req.head;\n";
    public static final String TYPE01_REQ_PACKAGE_PATH_SUFFIX = "^projectPath$.model.req;\n";

    public static final String TYPE01_RES_BODY_PACKAGE_PATH_SUFFIX = "^projectPath$.model.res.body;\n";
    public static final String TYPE01_RES_HEAD_PACKAGE_PATH_SUFFIX = "^projectPath$.model.res.head;\n";
    public static final String TYPE01_RES_PACKAGE_PATH_SUFFIX = "^projectPath$.model.res;\n";

    public static final String TYPE01_SERVICE_INTERFACE_PACKAGE_PATH_SUFFIX = "^projectPath$.service;\n";
    public static final String TYPE01_SERVICE_PACKAGE_PATH_SUFFIX = "^projectPath$.service.impl;\n";

    /**
     * importClassList import com.example.springBootDemo.util.StringBuilderUtil;
     */
    public static final String TYPE01_IMPORT = "import ";
    public static final String TYPE01_IMPORT_SUFFIX = "^packagePathSuffix$.^.^className$;";
    //  ***********************import
    public static final String TEMPLATE_PACKAGE_PATH_SUFFIX_NAME = "^packagePathSuffix$";
    //  TODO importMAP
    public static final String IMPORT_JSONPROPERTY_NAME = "JsonProperty";
    public static final String IMPORT_JSONPROPERTY_VAULE = "import com.fasterxml.jackson.annotation.JsonProperty;";

    /**
     * classNameTemplate
     *
     * @Slf4j
     * @RestController
     * @RequestMapping("student")
     * @Api(tags = {"student", "用Student数据测试分页"})
     * public class pageTestController {
     */
    public static final String TYPE01_ACTION_CLASS_NAME_01 = "@Slf4j\n@RestController\n@RequestMapping(\"^classNamePrefix$\")\n";
    public static final String TYPE01_ACTION_CLASS_NAME_02 = "public class ^className$ {\n";
    public static final String TYPE01_ACTION_CLASS_NAME_SWAGGER = "@Api(tags = {\"^classChinessName$\", \"\"})\n";
    /**
     * @Slf4j
     * @Service
     * @EnableTransactionManagement public class StudentService implements IStudentService {
     */
    public static final String TYPE01_SERVICE_CLASS_NAME_01 = "@Slf4j\n@Service\n";
    public static final String TYPE01_SERVICE_CLASS_NAME_02 = "public class ^className$ implements ^iServiceClassName$ {\n";
    /**
     * public interface ICreateService {
     */
    public static final String TYPE01_ISERVICE_CLASS_NAME = "public interface ^className$ {\n";
    /**
     * @Data
     * @ApiModel(description = "修改抵扣参数请求")
     * public class AgentdeductionRationReqVo {
     */
    public static final String TYPE01_MESSAGE_CLASS_NAME_01 = "@Data\n";
    public static final String TYPE01_MESSAGE_CLASS_NAME_02 = "public class ^className$ {\n";

    public static final String TYPE01_REQ_HEAD_CLASS_NAME_SWAGGER = "@ApiModel(description = \"^apiChineseName$请求头\")\n";
    public static final String TYPE01_REQ_CLASS_NAME_SWAGGER = "@ApiModel(description = \"^apiChineseName$参数请求\")\n";
    public static final String TYPE01_REQ_BODY_CLASS_NAME_SWAGGER = "@ApiModel(description = \"^apiChineseName$请求体\")\n";

    public static final String TYPE01_RES_HEAD_CLASS_NAME_SWAGGER = "@ApiModel(description = \"^apiChineseName$响应头\")\n";
    public static final String TYPE01_RES_CLASS_NAME_SWAGGER = "@ApiModel(description = \"^apiChineseName$参数响应\")\n";
    public static final String TYPE01_RES_BODY_CLASS_NAME_SWAGGER = "@ApiModel(description = \"^apiChineseName$响应体\")\n";
    //  ***********************类名
    public static final String TEMPLATE_CLASS_NAME_PREFIX_NAME = "^classNamePrefix$";
    public static final String TEMPLATE_ACTION_CLASS_NAME_PREFIX_NAME = "^actionClassNamePrefix$";
    public static final String TEMPLATE_CLASS_NAME_NAME = "^className$";
    public static final String TEMPLATE_I_SERVICE_CLASS_NAME_NAME = "^iServiceClassName$";
    public static final String TEMPLATE_API_CHINESE_NAME_NAME = "^apiChineseName$";
    public static final String TEMPLATE_CLASS_CHINESS_NAME_NAME = "^classChinessName$";

    /**
     * @Autowired
     * private AgentService agentService;
     */
    public static final String TYPE01_ACTION_FIELD_NAME_01 = "        @Autowired\n";
    public static final String TYPE01_ACTION_FIELD_NAME_02 = "        private ^iServiceClassName$ ^serviceFieldClassName$;\n";


    /**
     * @Autowired
     * private StudentDao dao;
     */
//    public static final String TYPE01_SERVICE_FIELD_NAME_01 = "@Autowired";
//    public static final String TYPE01_SERVICE_FIELD_NAME_02 = "private ^classNamePrefix$Mapper ^classNamePrefix$Mapper;";

    /**
     * public static final String API_STU_GET_STUDENT_BY_ID = "STU_001";
     * public static final String DESC_STU_GET_STUDENT_BY_ID = "根据学号获得学生信息";
     */
    public static final String TYPE01_CONFIG_FIELD_NAME_01 = "public static final String API_^fieldName$ = \"^fieldValue$\";\n";
    public static final String TYPE01_CONFIG_FIELD_NAME_02 = "public static final String DESC_^fieldName$ = \"^fieldNote$\";\n\n";

    /**
     * @ApiModelProperty(value = "学生姓名", required = true)
     * @JsonProperty("NAME") private String name;
     */
    public static final String TYPE01_MESSAGE_FIELD_NAME_01 = "        private ^fieldType$ ^fieldName$;\n";
    public static final String TYPE01_MESSAGE_FIELD_SWAGGER_01 = "        @ApiModelProperty(value = \"^fieldNote$\", required = ^fieldRequireType$)\n";
    public static final String TYPE01_MESSAGE_FIELD_SWAGGER_02 = "        @JsonProperty(\"^aliasFieldName$\")\n";
    //  ***********************属性名
    public static final String TEMPLATE_SERVICE_CLASS_NAME_NAME = "^serviceClassName$";
    public static final String TEMPLATE_SERVICE_FIELD_CLASS_NAME_NAME = "^serviceFieldClassName$";
    public static final String TEMPLATE_FIELD_NAME_NAME = "^fieldName$";
    public static final String TEMPLATE_ALIAS_FIELD_NAME_NAME = "^aliasFieldName$";
    public static final String TEMPLATE_FIELD_VALUE_NAME = "^fieldValue$";
    public static final String TEMPLATE_FIELD_NOTE_NAME = "^fieldNote$";
    public static final String TEMPLATE_FIELD_TYPE_NAME = "^fieldType$";
    public static final String TEMPLATE_FIELD_REQUIRE_TYPE_NAME = "^fieldRequireType$";


    /**
     * @ApiOperation(value = "清空数据后批量插入")
     * @ApiImplicitParam(name = "req", value = "学生对象测试", required = true, dataType = "Req")
     * @PostMapping(value = ApiConstant.API_BATCH_SAVE, name = ApiConstant.DESC_BATCH_SAVE)
     * public Res test(@Valid @RequestBody Req req) throws Exception{
     * return service.getStudentById(req);
     * }
     */
    public static final String TYPE01_ACTION_METHOD_SWAGGER_01 = "        @ApiOperation(value = \"^apiFieldNote$\")\n";
    public static final String TYPE01_ACTION_METHOD_SWAGGER_02 = "        @ApiImplicitParam(name = \"req\", value = \"^serviceClassChineseName$\", required = true, dataType = \"^reqClassName$\")\n";
    public static final String TYPE01_ACTION_METHOD_NAME_01 = "        @PostMapping(value = ^configClassName$.^configFieldValue$, name = ^configClassName$.^configDescFieldName$)\n";
    public static final String TYPE01_ACTION_METHOD_NAME_02 = "        public ^resClassName$ ^actionMethodName$(@Valid @RequestBody ^reqClassName$ req) throws Exception {\n";
    public static final String TYPE01_ACTION_METHOD_NAME_03 = "                return ^serviceFieldClassName$.^actionMethodName$(req);\n        }\n";
    /**
     * @Override
     * @MethodAnnotation(methodName = ApiConstant.DESC_PAGE_TEST)
     * public res list(Req req) {
     * return null;
     * }
     */
    public static final String TYPE01_SERVICE_METHOD_NAME_01 = "        @Override\n        @MethodAnnotation(methodName = ^configClassName$.^configDescFieldName$)\n";
    public static final String TYPE01_SERVICE_METHOD_NAME_02 = "        public ^resClassName$ ^actionMethodName$(^reqClassName$ req) throws Exception {\n";
    public static final String TYPE01_SERVICE_METHOD_NAME_03 = "                return null;\n        }\n";
    /**
     * res save(Req req)throws Exception;
     */
    public static final String TYPE01_SERVICE_INTERFACE_METHOD_NAME = "        ^resClassName$ ^actionMethodName$(^reqClassName$ req) throws Exception;\n";
    //  ***********************属性名
    public static final String TEMPLATE_API_FIELD_NOTE_NAME = "^apiFieldNote$";
    public static final String TEMPLATE_SERVICE_FILED_CLASS_NAME_NAME = "^serviceFieldClassName$";
    public static final String TEMPLATE_SERVICE_CLASS_CHINESE_NAME_NAME = "^serviceClassChineseName$";
    public static final String TEMPLATE_CONFIG_FIELD_VALUE_NAME = "^configFieldValue$";
    public static final String TEMPLATE_CONFIG_CLASS_NAME_NAME = "^configClassName$";
    public static final String TEMPLATE_CONFIG_DESC_FIELD_NAME_NAME = "^configDescFieldName$";
    public static final String TEMPLATE_RES_CLASS_NAME_NAME = "^resClassName$";
    public static final String TEMPLATE_ACTION_METHOD_NAME_NAME = "^actionMethodName$";
    public static final String TEMPLATE_REQ_CLASS_NAME_NAME = "^reqClassName$";
}
