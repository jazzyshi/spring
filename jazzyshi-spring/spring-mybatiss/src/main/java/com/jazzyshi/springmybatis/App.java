package com.jazzyshi.springmybatis;

import com.jazzyshi.springmybatis.pojo.Airport;
import com.jazzyshi.springmybatis.service.impl.AirportServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext 默认去classes文件夹根目录开始寻找
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		String[] names = ac.getBeanDefinitionNames();
//		for (String string : names) {
//			System.out.println(string);
//		}
        AirportServiceImpl bean = ac.getBean("airportService",AirportServiceImpl.class);
        List<Airport> list = bean.show();
        System.out.println(list);
    }
}
