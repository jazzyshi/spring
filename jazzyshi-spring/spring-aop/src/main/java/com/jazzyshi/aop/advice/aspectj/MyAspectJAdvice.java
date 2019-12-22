package com.jazzyshi.aop.advice.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 新建一个类就行 不需要实现接口
 * 类中的方法名任意
 */
public class MyAspectJAdvice {
    public void myBefore1(String name1,int age1){
        System.out.println("AspectJ-前置"+name1+":"+age1);
    }
    public void myBefore2(String name1){
        System.out.println("AspectJ-前置"+name1);
    }
    public void myAftering(){
        System.out.println("AspectJ-后置myAftering");
    }
    public void myAfter(){
        System.out.println("AspectJ-后置myAfter");
    }
    public void myThrow(){
        System.out.println("AspectJ-异常");
    }
    public Object myArround(ProceedingJoinPoint p) throws Throwable{
        System.out.println("执行AspectJ环绕");
        System.out.println("执行AspectJ环绕-前置");
        Object result = p.proceed();
        System.out.println("执行AspectJ环绕-后置");
        return result;
    }
}
