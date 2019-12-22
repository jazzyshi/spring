package com.jazzyshi.aop.advice.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Aspect相当于<aop:aspect/> 表示通知方法在当前的类中
 */
@Component
@Aspect
public class MyAnnotationAdvice {
    @Before("com.jazzyshi.aop.DemoAnn.demo()")
    public void myBefore(){
        System.out.println("前置");
    }

    @After("com.jazzyshi.aop.DemoAnn.demo()")
    public void myAfter(){
        System.out.println("后置");
    }

    @AfterThrowing("com.jazzyshi.aop.DemoAnn.demo()")
    public void myThrown(){
        System.out.println("异常通知");
    }

    @Around("com.jazzyshi.aop.DemoAnn.demo()")
    public Object myArround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("前置");
        Object result = point.proceed();
        System.out.println("后置");
        return result;
    }

}
