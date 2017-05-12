package com.design.test.filter;

/**
 * @author haichaow
 * @date 2017年5月2日
 * @description
 */
public class FilterManager {

	// 饿汉式
	private static FilterManager _instance = new FilterManager();

	public static FilterManager getInstance() {
		return _instance;
	}

	private FilterManager() {

	}

	public void doFilter() {

		// TODO

	}

	private FilterPlugin[] plugins;

	public FilterPlugin[] getFilterPlugins() {
		if (plugins == null) {
			// TODO 可以通过配置
		}

		return plugins;
	}

}
