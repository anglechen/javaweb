/**
 *
 */
package com.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.server.dao.UserDao;
import com.server.dao.impl.UserDaoImpl;

/**
 * @author Administrator
 * @date 2018年5月4日 下午2:29:26
 * 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{


	
	/**
	 * 登出用get处理
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		resp.setContentType("application/json;character=utf-8");
		PrintWriter pw = resp.getWriter();
		JSONObject json = new JSONObject();
		json.put("loginOut", "success");
		pw.write(json.toJSONString());
	}

	/**
	 * 登录post处理
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		name = name!=null?name:"";
		String password = req.getParameter("password");
		password = password!=null?password:"";
		if("admin".equals(name) && "admin".equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("error", "用户名或密码错误！请重试！");
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	
	

}
