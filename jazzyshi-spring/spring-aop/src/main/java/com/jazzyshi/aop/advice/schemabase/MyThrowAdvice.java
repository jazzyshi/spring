package com.jazzyshi.aop.advice.schemabase;

import javafx.beans.binding.ObjectExpression;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class MyThrowAdvice implements ThrowsAdvice {

    /**
     * 异常通知必须要实现ThrowsAdvice接口
     * 必须自己写方法，且名字必须是afterThrowing
     * 有两种参数方式（1个参数或者4个参数）
     * 异常类型要与切点报的异常一致
     * @param e
     * @throws Exception
     */
    public void afterThrowing (Exception e) throws Throwable{
        System.out.println("执行异常通知方法-schema-base方式");
    }

//    public void afterThrowing (Method m, Object[] args, Object target, Exception e) throws Throwable{
//        System.out.println("执行异常通知方法-schema-base方式");
//    }
}
