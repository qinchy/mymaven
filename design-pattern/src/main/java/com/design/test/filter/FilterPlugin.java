package com.design.test.filter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author haichaow
 * @date 2017年5月2日
 * @description
 */
public interface FilterPlugin {

	public String getName();

	public void setName(String name);

	public void doFilter(HttpServletRequest request, HttpServletRequest response, FilterPluginChain chain);

	public void init();

}
