package com.jazzyshi.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class DemoAop {
    public void study(){
        System.out.println("好好学习");
    }

    public void studyThrow(){
        System.out.println("方法执行有异常");
        try {
            throw new NumberFormatException("数字异常");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void studyArround(){
        System.out.println("执行我自己的arround");
    }
    public static void main(String[] args){
        //直接调用不行，不会加切面，为啥 废话
        DemoAop demoAop = new DemoAop();
        demoAop.study();

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        DemoAop demo = ac.getBean("demoAop",DemoAop.class);
        demo.study();
        demo.studyThrow();
        demo.studyArround();
    }
}
