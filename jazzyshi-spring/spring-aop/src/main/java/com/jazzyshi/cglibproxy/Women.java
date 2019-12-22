package com.jazzyshi.cglibproxy;


import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib的优点：
 * 1.基于字节码 生成真实对象的子类 运行效率高于JDK动态代理
 * 2.不需要实现接口
 *
 * cglib的缺点
 * 1.非jdk的功能需要额外导入jar
 *
 * 使用springaop时，只要出现peoxy和真实对象转化异常
 * 1.设置为true使用cglib
 * 2.设置为false使用jdk(默认值)
 * <aop:aspectj-autoproxy proxy-target-class="true"/>
 */
public class Women {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Laozong.class);
		enhancer.setCallback(new Mishu());
		
		Laozong laozong = (Laozong) enhancer.create();
		laozong.chifan();
		
	}
}
