package com.jdld.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdld.entity.ShoppMsg;
import com.jdld.service.ManagedServlet;
import com.jdld.service.impl.ManagedServletImpl;

import net.sf.json.JSONArray;

/**
 * @获取购物车信息
 */
@WebServlet("/GetShoppMsgServlet")
public class GetShoppMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String id=request.getParameter("ids");//对应用户的UID
		
		ManagedServlet managedServlet=new ManagedServletImpl();
		List<ShoppMsg> shoppMsgs=new ArrayList<ShoppMsg>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("UID", id);
		shoppMsgs=managedServlet.findShoppMsg(map);//获取对应的用户购物车信息
		
		JSONArray jsonObjects = JSONArray.fromObject(shoppMsgs);
		response.getWriter().print(jsonObjects.toString());
	}

}
