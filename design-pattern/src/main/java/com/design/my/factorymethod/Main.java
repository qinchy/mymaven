package com.design.my.factorymethod;

/**
 * 
 * @author chaoyong.qin
 *
 */
public class Main {

	public static void main(String[] args) {
		IFactory factory = new BmwFactory();
		Car car = factory.create();
		car.drive();
	}

}
