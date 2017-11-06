package com.darcytech.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Created by GXL on 2016/7/28.
 */


@Aspect
public class LogInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.darcytech.service.VisitLogService.save(..))")
    private void log(){}

    @Around("log()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("有人进入");
        Object object = pjp.proceed();//执行该方法
        return object;
    }

}
