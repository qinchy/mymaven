/**
 * 
 */
package com.design.my.factorymethod;

/**
 * @author chaoyong.qin
 *
 */
public class BenzFactory implements IFactory {

	@Override
	public Car create() {
		return new Benz();
	}

}
