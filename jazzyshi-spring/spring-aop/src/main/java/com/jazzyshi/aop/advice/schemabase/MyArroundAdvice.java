package com.jazzyshi.aop.advice.schemabase;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知---把前置通知和后置通知都写到一个通知中，组成了环绕通知
 * 实现步骤：
 *  新建一个实现类MethodInterceptor
 */
public class MyArroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕-前置");
        //放行，调用切点方法
        Object result = methodInvocation.proceed();
        System.out.println("环绕-后置");
        return result;
    }
}
