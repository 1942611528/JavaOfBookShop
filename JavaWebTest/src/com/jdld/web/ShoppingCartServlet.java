package com.jdld.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdld.entity.Books;
import com.jdld.service.ManagedServlet;
import com.jdld.service.impl.ManagedServletImpl;

import net.sf.json.JSONObject;

/**
 * @设置购物车
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String listsTos=request.getParameter("listsTo");//商品列表
	    String id=request.getParameter("ids");//对应用户名
	    JSONObject jsonObject = JSONObject.fromObject(listsTos); //将json转为数组对象
	    String bid = jsonObject.getString("BID"); //图书ID
	    
	    Map<String, String> map=new HashMap<String, String>();//存放条件
	    ManagedServlet managedServlet=new ManagedServletImpl();
	    
	    map.put("ORDERITEMID", bid);//主键
	    Books shoppMsg=managedServlet.getBookByUid(map);//获取要添加的书本
	    map.put("QUANTITY", "1");//数量
	    map.put("SUBTOTAL", shoppMsg.getCURRPRICE()+"");//小计
	    map.put("BID", shoppMsg.getBID());//书本id
	    map.put("BNAME", shoppMsg.getBNAME());//图书名称
	    map.put("CURRPRICE", shoppMsg.getCURRPRICE()+"");//图书当前价
	    map.put("IMAGE_B", shoppMsg.getIMAGE_B());//图书小图路径
	    map.put("OID", bid);//所属订单号
	    map.put("HAS", "0");//删除状态)
	    System.out.println("shoppMsg="+shoppMsg);
	    
		if(id!=null) {
			//managedServlet.setBookOfSp(map);//添加到 
		}
		String js="{\"nub\":"+1+",\"currPrice\":"+shoppMsg.getCURRPRICE()+",\"name\":\""+shoppMsg.getBNAME().split("$")[0]+"\",\"image_b\":\""+shoppMsg.getIMAGE_B()+"\"}";
		JSONObject jsonObjects = JSONObject.fromObject(js);
		response.getWriter().print(jsonObjects.toString());
	}

}
