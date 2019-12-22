package com.jazzyshi.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class DemoAspectJ {
    public void demo1(String name1,int age1){
        System.out.println("demo1");
    }
    public void demo1(String name1){
        System.out.println("demo2");
    }

    public void demoAfter(){
        System.out.println("AspectJ-后置demoAfter");
    }
    public void demoAftering(){
        System.out.println("AspectJ-后置myAftering");
    }
    public void demoyAfter(){
        System.out.println("AspectJ-后置myAfter");
    }
    public void demoThrow(){
        System.out.println("AspectJ-异常");
    }

    public static void main(String[] args){

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        DemoAspectJ demo = ac.getBean("demoAspectJ", DemoAspectJ.class);
        demo.demo1("史继卓",18);
        demo.demo1("史继卓");
        demo.demoAfter();
    }
}
