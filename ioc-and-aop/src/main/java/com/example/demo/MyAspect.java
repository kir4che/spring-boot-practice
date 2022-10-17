package com.example.demo;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

//    @Before("execution(* com.example.demo.HpPrinter.*(..))")
//    public void before() {
//        System.out.println("I'm before.");
//    }
//
//    @After("execution(* com.example.demo.HpPrinter.*(..))")
//    public void after() {
//        System.out.println("I'm after.");
//    }

    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();

        Object obj = pjp.proceed(); // 執行原本切入點的方法（HpPrinter－print()）

        Date end = new Date(); // 紀錄當下的結束時間
        long time = end.getTime() - start.getTime();
        System.out.println("Total time " + time + " ms");

        return obj;
    }
}
