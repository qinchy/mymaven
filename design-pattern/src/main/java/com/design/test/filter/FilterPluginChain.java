package com.design.test.filter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author haichaow
 * @date 2017年5月2日
 * @description
 */
public interface FilterPluginChain {

	public void doFilter(HttpServletRequest request, HttpServletRequest response);
	
	public FilterPluginChain getParent();

}
