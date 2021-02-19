package com.example.springBootDemo.config.components.aop;

import com.alibaba.fastjson.JSON;
import com.example.springBootDemo.config.components.error.BizException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @所属模块 配置-切片-接口
 * @描述 <p>适用于所有Controler层方法。对输入输出的结果和时间进行打印和统计<p/>
 * @创建人 xiaoYe
 * @创建时间 2020/4/30 20:50
 * @备注 与其他切面控制互斥
 */
@Aspect
@Component
@Slf4j
public class AopActionConfig {

    private static ThreadLocal<Map> threadLocal = new ThreadLocal<Map>();

//    @Autowired
//    private TransactionUtils transactionUtils;

    //    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.PostMapping)")
    @Pointcut("execution(* com.example.springBootDemo.controller.*.*(..))")
    public void pointcut() {
    }

    /**
     * <p>环绕增强</p>
     * <p></p>
     *
     * @param pjp
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
//         打印请求参数
//          获得目标反射类的方法
            String methodName = pjp.getSignature().getName();
            Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
            Class aClass = pjp.getTarget().getClass();
            Method method = aClass.getMethod(methodName, parameterTypes);

//          获得接口注解名字
            PostMapping postMapping = method.getAnnotation(PostMapping.class);
            String[] anMethodName = null;
            String apiMapping = "";
            if (postMapping != null) {
                anMethodName = postMapping.value();
                apiMapping = postMapping.name();
            }

//          打印请求参数 TODO 顺序不知道有没有问题
            StringBuffer parameter = new StringBuffer();
            Object[] parameterVaules = pjp.getArgs();
            DefaultParameterNameDiscoverer discover = new DefaultParameterNameDiscoverer();
            String[] parameterNames = discover.getParameterNames(method);
            for (int i = 0; i < parameterVaules.length; i++) {
                if (parameter.length() > 0) parameter.append(",");
                parameter.append(parameterNames[i] + ":" + parameterVaules[i]);
            }
            log.info("[{}]{}↓↓↓接口参数:[{}]", apiMapping, anMethodName, parameter);

//          配置事物
//            method.(PostMapping.class);

//         执行时间与结果
            StopWatch sw = new StopWatch("接口计时器");
//            ThreadLocal.
            sw.start();
            proceed = actionTemplate(pjp);
            Object printResult = proceed;
            if (proceed == null) {
                printResult = "void";
            }
            sw.stop();
            log.info("[{}]{}接口执行结果[{}]: ", apiMapping, anMethodName, printResult);
//            log.info(sw.prettyPrint());
            log.info("[{}]{}↑↑↑接口执行时间[{}]ms", apiMapping, anMethodName, sw.getTotalTimeMillis());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    /**
     * 模板化action执行
     * 该模板主要完成异常处理、事物管理
     * 与其他系统交互时，请注意事物处理的影响
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    private Object actionTemplate(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = "";
        try {
            obj = pjp.proceed();
        } catch (BizException e) {
//          TODO 返回外部异常信息 2020-5-21 未测试
            log.error("业务处理异常！！！[{}]", e.getMessage());
        } catch (Exception e) {
            log.error("接口逻辑异常！！！[{}]", e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }
}
