package com.design.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
* @author  haichaow
* @date    2017年5月2日 
* @description 
*/
public class MainFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 可初始化跳转的URI，出错和提示类页面地址

	}
	
	private static ThreadLocal localThread =  new ThreadLocal();

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (localThread.get()==null) {
			localThread.set(Boolean.TRUE);
			try {
				doInternalFilter(request,response,chain);
			} finally{
				localThread.remove();
			}
			
		}
		
		

	}

	private void doInternalFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		// TODO 按需求处理其他内容，如uri路径格式化
		
		//如何处理多个过滤器？？
		
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
 