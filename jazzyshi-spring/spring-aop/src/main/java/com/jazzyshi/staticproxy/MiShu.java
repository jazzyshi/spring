package com.jazzyshi.staticproxy;

/**
 * 静态代理的缺点：
 * 每个代理功能都要单独编写
 * 当代理功能比较多时，代理类中的方法需要写很多
 */
public class MiShu implements Gongneng{
	private Laozong laozong = new Laozong("云云");

	@Override
	public void zhidingxiaomubiao() {
		System.out.println("秘书约定时间");
		laozong.zhidingxiaomubiao();
		System.out.println("秘书把访客信息备注");
	}

	@Override
	public void chifan() {
		System.out.println("秘书约定时间");
		laozong.chifan();
		System.out.println("秘书把访客信息备注");
	}
	
	
}
