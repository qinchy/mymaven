/**
 * 
 */
package com.design.my.abstracefactory;

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
