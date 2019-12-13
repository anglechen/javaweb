/**
 *
 */
package com.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.server.domain.User;
import com.server.service.UserService;
import com.server.service.impl.UserServiceImpl;
import com.server.utils.ServletParamsUtil;

/**
 * @author Administrator
 * @date 2018年5月4日 下午2:29:35
 * 
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	
	private UserService userService = new UserServiceImpl();
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserServiceImpl();
		User paramsUser = ServletParamsUtil.convertReqestToJson( req.getParameterMap(), new User());
		try {
			userService.add(paramsUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		JSONObject json  =new JSONObject();
		User paramUser = ServletParamsUtil.convertInputstreamToObject(req.getInputStream(), new User());
		UserService userService = new UserServiceImpl();
		if(paramUser == null) {
			json.put("result", "参数异常");
			out.write(json.toJSONString());
		}
		try {
			userService.mod(paramUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		json.put("result", true);
		out.write(json.toJSONString());
		
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		JSONObject json  =new JSONObject();
		JSONObject params = ServletParamsUtil.convertInputstreamToJson(req.getInputStream());
		UserService userService = new UserServiceImpl();
		if(params == null) {
			json.put("result", "参数异常");
			out.write(json.toJSONString());
		}
		String strids = params.getString("ids");
		if(strids != null) {
			if(strids != "" && strids.indexOf(",") != -1) {
				String ids[] = strids.split(",");
				for(String id : ids) {
					try {
						userService.del(Integer.parseInt(id));
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else {
				try {
					userService.del(Integer.parseInt(strids));
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
			}
		}

		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		long start = System.currentTimeMillis();
		User paramsUser = ServletParamsUtil.convertReqestToJson( req.getParameterMap(), new User());
		String rdata =  req.getParameter("tdata");
			if(paramsUser == null) {
				JSONObject json = new JSONObject();
				json.put("data", null);
				out.write(json.toJSONString());
				return;
			}
//			UserService userService = new UserServiceImpl();
			
			JSONObject json = new JSONObject();
			try {
				json.put("data", userService.selectAll(paramsUser));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//设置返回json数据格式		
			resp.setContentType("text/json"); 
	        /*设置字符集为'UTF-8'*/
			resp.setCharacterEncoding("utf-8"); 
			System.out.println("耗费时间" + (System.currentTimeMillis() - start));
			out.write( JSON.toJSONString(json));
		
	}
	

}
