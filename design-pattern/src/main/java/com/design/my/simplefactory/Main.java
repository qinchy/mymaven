/**
 * 
 */
package com.design.my.simplefactory;

/**
 * @author chaoyong.qin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Car car = SimpleFactory.create("Benz");
		car.drive();
	}

}
