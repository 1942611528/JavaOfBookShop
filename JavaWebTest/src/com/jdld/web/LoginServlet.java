package com.jdld.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdld.entity.Manager;
import com.jdld.service.ManagedServlet;
import com.jdld.service.impl.ManagedServletImpl;
import com.jdld.util.SetBookMsgUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServlet @ 负责管理员登录
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取前端数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");// chk11
		String checkVals = request.getParameter("chk11");

		ManagedServlet managerServlet = new ManagedServletImpl();
		SetBookMsgUtil setBookMsgUtil = new SetBookMsgUtil();//数据设置工具类

		JSONObject jo = new JSONObject();
		Map<String, String> map = new HashMap<String, String>();// 将多参数存入map

		//System.out.println("chk11=" + checkVals + ",username=" + username + ",password=" + password);

		map.put("username", username);// 设置用户名与密码到后台查找
		map.put("userkey", password);
		Manager hasManager = managerServlet.managerHas(map);// 提交到后台查询是否存在

		if (hasManager != null && username.equals(hasManager.getLOGINNAME())
				&& password.equals(hasManager.getLOGINPASS())) {// 判断是否存在该管理员
			jo = setBookMsgUtil.setObjectType(jo, hasManager);
			request.getSession().setAttribute("loginUser", hasManager);// 保存工作凭证
			if (!"1".equals(checkVals)) {// 用户有没有选择记住
				Cookie[] cookies = request.getCookies();
				if (cookies != null && cookies.length > 0) {
					for (Cookie cookie : cookies) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			} else {
				Cookie cookie = new Cookie("login", username + "#" + password);// 创建cookie
				cookie.setMaxAge(7 * 24 * 60 * 60);// 设置保存7天
				cookie.setPath(request.getContextPath());// 设置path
				response.addCookie(cookie);// 保存到客户端否则无效
			}
			response.getWriter().print(jo.toString());
			System.out.println("存在");
		} else {// 用戶不存在時
			Manager hasManager1 = new Manager();
			hasManager1.setLogin(false);
			jo = setBookMsgUtil.setObjectType(jo, hasManager1);
			response.getWriter().print(jo.toString());
			System.out.println("不存在");
		}
	}

}
