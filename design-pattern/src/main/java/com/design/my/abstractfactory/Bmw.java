/**
 * 
 */
package com.design.my.factorymethod;

/**
 * @author chaoyong.qin
 *
 */
public class Bmw implements Car {
	@Override
	public void run() {
		System.out.println("Bmw开始启动了。。。。。");
	}

	@Override
	public void stop() {
		System.out.println("Bmw停车了。。。。。");
	}

}
