package com.design.my.simplefactory;

public class SimpleFactory {
	public static Car create(String name) {
		if ("Bmw".equals(name)) {
			return new Bmw();
		} else if ("Benz".equals(name)) {
			return new Benz();
		} else {
			return null;
		}
	}
}
