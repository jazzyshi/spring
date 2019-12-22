package com.jazzyshi.aop.advice.annotation;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class DemoAnnotation {
    //在方法上添加@pointcut("")定义切点
    @Pointcut("execution(* com.jazzyshi.aop.advice.annotation.DemoAnnotation.demo(..))")
    public void demo() {
        // int  i = 5 /0 ;
        System.out.println("demoAnnotation");
    }
}
