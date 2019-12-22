package com.jazzyshi.spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        String[] bnames = ac.getBeanDefinitionNames();

        for(String b : bnames) {
            System.out.println(b+":"+ac.getBean(b));
        }
    }
}
