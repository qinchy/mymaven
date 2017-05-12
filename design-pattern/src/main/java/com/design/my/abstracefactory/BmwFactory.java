/**
 * 
 */
package com.design.my.abstracefactory;

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
