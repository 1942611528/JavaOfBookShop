package com.jdld.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @历史记录保存
 */
@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
	    String hestTypes=request.getParameter("hestType");
	    String hestDatas=request.getParameter("hestData");
	    System.out.println(hestDatas);
	    System.out.println("hestData="+hestDatas+",hestType="+hestTypes);
	    if("1".equals(hestTypes)) {//用户选择删除时
			Cookie[] cookies=request.getCookies();
			if(cookies!=null&&cookies.length>0) {
				for(Cookie cookie : cookies) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}else {
			Cookie cookie=new Cookie("hert", hestDatas);//创建cookie
			cookie.setMaxAge(7*24*60*60);//设置保存7天
			cookie.setPath(request.getContextPath());//设置path
			response.addCookie(cookie);//保存到客户端否则无效
		}
		response.getWriter().print("");
	}

}
