package com.example.springBootDemo.config.components.aop;

import com.example.springBootDemo.config.parameters.annotation.MethodAnnotation;
import com.example.springBootDemo.config.parameters.annotation.SqlAnnotation;
import com.example.springBootDemo.config.components.error.BizException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @所属模块 配置-切片-方法
 * @描述 <p>适用于所有service层方法，打印方法输入输出与执行时间<p/>
 * @创建人 xiaoYe
 * @创建时间 2020/5/2 15:42
 * @备注 与其他切面控制互斥
 */
@Aspect
@Component
@Slf4j
public class AopMethodConfig {
    //    通过注解的方式
//    @Pointcut("execution(* com.example.springBootDemo.service.impl..*(..))")
    @Pointcut(value = "@annotation(com.example.springBootDemo.config.parameters.annotation.MethodAnnotation)")
    public void pointcut() {
        log.info("这里不知道什么后会触发");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
//          获得目标方法
            String methodName = pjp.getSignature().getName();
            Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
            Class aClass = pjp.getTarget().getClass();
            Method method = aClass.getMethod(methodName, parameterTypes);

//          根据方法注解配置打印参数
            String anMethodName = printArgs(pjp, methodName, method);

//          打印处理时间和返回结果
            long startTime = System.currentTimeMillis();
            proceed = methodTemplate(pjp);
            long execTime = System.currentTimeMillis() - startTime;
            Object printResult = proceed;
            if (proceed == null) {
                printResult = "void";
            }
            log.info("[{}][{}]方法执行结果[{}]: ", anMethodName, methodName, printResult);
            log.info("[{}][{}]方法执行时间↑↑↑：[{}]毫秒", anMethodName, methodName, execTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    /**
     * 模板化method执行
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    private Object methodTemplate(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = "";
        try {
            obj = pjp.proceed();
        } catch (BizException e) {
            log.error("业务处理异常！！！[{}]", e.getMessage());
            throw new BizException(e.getMessage());
        } catch (Exception e) {
            log.error("接口逻辑异常！！！[{}]", e.getMessage());
            throw new Exception(e);
        }
        return obj;
    }


    /**
     * 打印参数
     *
     * @param pjp
     * @param methodName
     * @param method
     * @return
     */
    private String printArgs(ProceedingJoinPoint pjp, String methodName, Method method) {
        MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
        if (annotation == null) return "";
//      获取注解方法名
        String anMethodName = annotation.methodName();

        Boolean printArgsFlag = annotation.printArgsFlag();
        if (printArgsFlag) {
            StringBuffer parameter = new StringBuffer();
            Object[] parameterVaules = pjp.getArgs();
            DefaultParameterNameDiscoverer discover = new DefaultParameterNameDiscoverer();
            String[] parameterNames = discover.getParameterNames(method);
            for (int i = 0; i < parameterVaules.length; i++) {
                if (parameter.length() > 0) parameter.append(",");
                parameter.append(parameterNames[i] + ":" + parameterVaules[i]);
            }
            log.info("[{}][{}]方法参数:[{}]↓↓↓", anMethodName, methodName, parameter);
        }
        return anMethodName;
    }

    /**
     * 根据注解判断是否需要打印sql
     * TODO 未完成 2020-5-4 16:36:21
     *
     * @param methodName
     * @param method
     */
    private void printSql(String methodName, Method method) {
//       注解注释
        SqlAnnotation sqlAnnotation = method.getAnnotation(SqlAnnotation.class);
        if (sqlAnnotation == null) return;
//      获取注解函数值
        boolean printSqlFlag = sqlAnnotation.printSqlFlag();
        String printMethodName = sqlAnnotation.printMethodName();
        if (printSqlFlag || printMethodName.contains(methodName)) {
//                TODO 打印sql
            log.info("打印sql");
        }
    }
}
