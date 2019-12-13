package com.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter implements Filter {


	
	public EncodingFilter() {
		System.out.println("EncodingFilter.........");
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {

	}

	@Override
	// 核心方法,所有符合条件的请求会进入
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("-----doFilter-----");
		HttpServletRequest req = (HttpServletRequest)request;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//判断是否是ajax请求,并且值为XMLHttpRequest,表示客户端的请求为异步请求
		String requestType = req.getHeader("X-Requested-With"); 
		// 跳转到下一个过滤器,如果没有访问目标页面
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}


}
