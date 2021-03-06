package com.jazzyshi.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 解决静态代理频繁编写代理功能的缺点
 */
public class Mishu implements InvocationHandler {

	private Laozong laozong=new Laozong() ;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("method="+method.getName());
		if(method.getName() == "chifan"){
			System.out.println("吃饭预约时间");
		}else{
			System.out.println("其它预约时间");
		}
		//真实对象laozong
		Object result = method.invoke(laozong, args);
		System.out.println("记录访客信息");

		return result;
	}

}
