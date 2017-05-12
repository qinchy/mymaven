/**
 * 
 */
package com.design.my.factorymethod;

/**
 * @author chaoyong.qin
 *
 */
public class BmwFactory implements IFactory {

	@Override
	public Car create() {
		return new Bmw();
	}

}
