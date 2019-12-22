package com.jazzyshi.aop.advice.schemabase;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice {
    /**
     * 后置通知类
     * @param o       切点方法返回值
     * @param method  切点方法对象
     * @param objects 切点方法参数
     * @param o1      切点方法所在类对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行后置通知");
    }
}
