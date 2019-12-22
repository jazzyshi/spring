package com.jazzyshi.aop.advice.schemabase;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {

    /**
     * 前置通知类
     * @param method 切点方法对象Method对象
     * @param objects 切点方法参数
     * @param o        切点在哪个对象中
     * @throws Throwable
     */

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("执行前置通知");
    }
}
