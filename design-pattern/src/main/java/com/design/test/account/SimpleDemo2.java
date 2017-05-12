package com.design.test.account;

/**
 * @author haichaow
 * @date 2017年5月10日
 * @description
 */
public class SimpleDemo2 {

}

// 形状
interface Shape {
	void draw();
}

class Rectangle implements Shape {

	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}

class Circle implements Shape {

	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

// 颜色
interface Color {
	void fill();
}

class Red implements Color {

	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}

class Green implements Color {

	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}
}

// 抽象工厂
abstract class AbstractFactory {
	abstract Color getColor(String color);

	abstract Shape getShape(String shape);
}

