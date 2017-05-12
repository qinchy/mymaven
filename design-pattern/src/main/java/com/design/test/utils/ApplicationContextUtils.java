package com.design.test.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/** 
* @author  haichaow
* @date    2017年5月2日 
* @description 
*/
public class ApplicationContextUtils {
	
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ApplicationContextUtils.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object findInterfaceService(Class<?> clazz) {
		return applicationContext.getBean(clazz);
	}
	public static Object findInterfaceService(String className) {
		return applicationContext.getBean(className);
	}

}
 