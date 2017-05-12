package com.design.test.account;

/**
 * @author haichaow
 * @date 2017年5月10日
 * @description
 */
public class SimpleDemo {

}

interface Car {
	void drive();
}

class Benz implements Car {

	public void drive() {
		System.out.println("drive Benz");
	}

}

class Bmw implements Car {

	public void drive() {
		System.out.println("drive Bmw");
	}

}

class CarFactory {
	public static Car creator(String carType) {
		if (carType.equals("Benz")) {
			return new Benz();
		} else if (carType.equals("Bmw")) {
			return new Bmw();
		} else {
			throw new UnsupportedOperationException("car with type" + carType + " is not supported.");
		}
	}
}
