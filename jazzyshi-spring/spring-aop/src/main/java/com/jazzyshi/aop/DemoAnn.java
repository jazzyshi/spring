package com.jazzyshi.aop;

import com.jazzyshi.aop.advice.annotation.DemoAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Component
 * 相当于<bean/>
 * 如果没有参数，把类名首字母变小写，相当于<bean id=""/>
 * @Component("自定义名称")
 */
public class DemoAnn {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationAnnotation.xml");
        DemoAnnotation demoAnnotation =  ac.getBean("demoAnnotation", DemoAnnotation.class);
        demoAnnotation.demo();
    }
}
