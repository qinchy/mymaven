package com.design.test.filter.simple;

import javax.servlet.http.HttpServletRequest;

import com.design.test.filter.FilterPlugin;
import com.design.test.filter.FilterPluginChain;

/**
 * @author haichaow
 * @date 2017年5月2日
 * @description
 */
public class SimpleFilterPluginChain implements FilterPluginChain {

	FilterPlugin[] plugins;
	FilterPluginChain chain;
	int i = -1;

	public SimpleFilterPluginChain(FilterPlugin[] plugins, FilterPluginChain chain) {
		this.plugins = plugins;
		this.chain = chain;

	}

	public void doFilter(HttpServletRequest request, HttpServletRequest response) {
		i++;
		if (i < plugins.length) {
			plugins[i].doFilter(request, response, this);
		} else if (chain != null) {
			chain.doFilter(request, response);
		}

	}

	public FilterPluginChain getParent() {
		return this.chain;
	}

}
