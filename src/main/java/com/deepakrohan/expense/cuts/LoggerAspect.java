package com.deepakrohan.expense.cuts;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class    LoggerAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);


    @Before("execution(* com.deepakrohan.expense.*.*.*(..))")
    public void addLogStatement(JoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        LOGGER.info(
                "Log {}, {}, {}",
                point.getSignature(),
                Arrays.toString(point.getArgs()),
                System.currentTimeMillis() - start
        );

    }
}
