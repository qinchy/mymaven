package com.design.test.filter.simple;

import javax.servlet.http.HttpServletRequest;

import com.design.test.filter.FilterManager;
import com.design.test.filter.FilterPlugin;
import com.design.test.filter.FilterPluginChain;

/**
 * @author haichaow
 * @date 2017年5月2日
 * @description
 */
public class SimpleFilterPlugin implements FilterPlugin {
	private FilterManager manager;

	public SimpleFilterPlugin(String name, FilterManager manager) {
		this.manager = manager;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected FilterPlugin[] getFilterPlugins() {
		return manager.getFilterPlugins();
	}

	public void doFilter(HttpServletRequest request, HttpServletRequest response, FilterPluginChain chain) {
		chain = new SimpleFilterPluginChain(getFilterPlugins(), chain);
		chain.doFilter(request, response);
	}

	public void init() {

	}

}
