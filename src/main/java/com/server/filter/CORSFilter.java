/**
 *
 */
package com.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author aubrey
 * @date  上午8:42:11
 * 
 */
public class CORSFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 //设置跨域请求
        HttpServletResponse resp = (HttpServletResponse) response;         
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
//        resp.setHeader("Access-Control-Max-Age", "3628800"); 
 
        System.out.println("设置跨域请求");
        chain.doFilter(request, response);  		
	}

}
