package com.thcha.mini.aop;

import java.text.SimpleDateFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    // @Around("execution(* com.thcha.mini.controller.*Controller.*(..)) "+
    //         "or execution(* com.thcha.mini.service..*(..)) " +
    //         "or execution(* com.thcha.mini.repository..*(..))")
    @Around("execution(* com.thcha.mini.controller.*Controller.*(..))")
    public Object controllerLogPrint(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        String aopCallMethodName = joinPoint.getSignature().toShortString();

        logger.info(String.format("aop:controllerLogPrint:Before [%s] ... DateTime : [%s]", 
            aopCallMethodName, simpleDateFormat.format(startTime)));

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logger.info(String.format("aop:controllerLogPrint:After  [%s] ... DateTime : [%s] >>> Elapsed runtime : %.3f seconds", 
            aopCallMethodName, simpleDateFormat.format(endTime), (endTime - startTime)/1000.));

        return proceed;
    }


    @Around("@annotation(org.springframework.web.bind.annotation.RestController)")
    //@Around("@target(org.springframework.web.bind.annotation.RestController)")
    public Object restControllerLogPrint(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        String aopCallMethodName = joinPoint.getSignature().toShortString();

        logger.info(String.format("aop:restControllerLogPrint:Before [%s] ... DateTime : [%s]", 
            aopCallMethodName, simpleDateFormat.format(startTime)));

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logger.info(String.format("aop:restControllerLogPrint:After  [%s] ... DateTime : [%s] >>> Elapsed runtime : %.3f seconds",
            aopCallMethodName, simpleDateFormat.format(endTime), (endTime - startTime)/1000.));

        return proceed;
    }
}