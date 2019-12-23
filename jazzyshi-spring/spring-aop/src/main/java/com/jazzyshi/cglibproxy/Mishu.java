package com.jazzyshi.cglibproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class Mishu implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {

		System.out.println("Method="+arg1.getName());
		if(arg2.length>0){
			System.out.println("Object[] arg2="+arg2[0].toString());
		}

		System.out.println("预约时间");
		//invoke()调用子类重写的方法
		//Object result = arg1.invoke(arg0, arg2);
		//Object result = arg3.invokeSuper(arg0, arg2);
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("备注");
		return result;
	}

}
