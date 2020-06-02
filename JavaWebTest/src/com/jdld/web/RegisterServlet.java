package com.jdld.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 * @用户注册
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		ManagedServlet managerServlet=new ManagedServletImpl();
//		Users users=new Users();
		//获取前端数据
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String passwordAgain=request.getParameter("passwordAgain");
		String nickname=request.getParameter("nickname");
		String tel=request.getParameter("tel");
		String sex=request.getParameter("sex");
		System.out.println(username+","+email+","+password+","+passwordAgain+","+nickname+","+tel+","+sex);
	}

}
