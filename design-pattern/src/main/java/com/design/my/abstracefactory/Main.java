package com.design.my.abstracefactory;

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
