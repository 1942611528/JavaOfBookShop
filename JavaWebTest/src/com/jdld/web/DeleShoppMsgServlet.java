package com.jdld.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdld.service.ManagedServlet;
import com.jdld.service.impl.ManagedServletImpl;

import net.sf.json.JSONObject;

/**
 * @删除购物车指定信息
 */
@WebServlet("/DeleShoppMsgServlet")
public class DeleShoppMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String uid=request.getParameter("uids");//获取uid
		String bookname=request.getParameter("booknames");//获取书ID
		System.out.println("uid="+uid+",bookname="+bookname);
		Map<String,String> map=new HashMap<String,String>();
		map.put("UID", uid);
		map.put("BOOKNAME", bookname);
		map.put("has", "no");//删除
		ManagedServlet managedServlet=new ManagedServletImpl();
		int re=managedServlet.deleShoppMsg(map);
		if(re==1) {
			System.out.println("ok");
			//response.getWriter().print("ok".toString());
			String ok="ok";
			response.getWriter().print(JSONObject.fromObject("{\"has\":\""+ok+"\"}").toString());
		}else {
			String ok="no";
			System.out.println("no");
			response.getWriter().print(JSONObject.fromObject("{\"has\":\""+ok+"\"}").toString());
		}
	}

}
