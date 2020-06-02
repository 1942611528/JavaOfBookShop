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
import com.jdld.entity.Books;
import com.jdld.pageget.Page;
import com.jdld.pageget.pagegetutil.PageUtil;
import com.jdld.service.ManagedServlet;
import com.jdld.service.impl.ManagedServletImpl;
import com.jdld.util.SetBookMsgUtil;

import net.sf.json.JSONArray;

/**
 * 
 * @查询所有数据
 */
@WebServlet("/LookBookServlet")
public class LookBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");//设置编码
		response.setContentType("text/html;charset=UTF-8");
		
		Page page=null;//分页信息设置
		List<Books> books = null;//存放书本结果集
		int everyPage = 14;//每页的记录数
		int totalCount = 0;//获取总页数
		String pageSql="";//判断执行那种sql条件
		ManagedServlet managedServlet=new ManagedServletImpl();
		SetBookMsgUtil setBookMsgUtil=new SetBookMsgUtil();//属性设置工具类
		String currentPageTo=request.getParameter("currentPage");//获取前端的查询选项值
		String lookfor=request.getParameter("lookfor");//获取查询类型
		String scurrentPage=request.getParameter("currentPage");//获取当前页码数据
		String keyword=request.getParameter("keyword");//获取的搜索参数
		String[] lookfors=lookfor.split("");//获取第二位数
		String lookf1="";
		String lookf2="";
		int currentPageToInt=Integer.parseInt(currentPageTo);//页面数据类型转换
		int currentPage =currentPageToInt;//设置页码,默认为1
		if(scurrentPage == null) {//设置当页码
			currentPage =1;//从第一页开始访问
		}else {
			currentPage =Integer.parseInt(scurrentPage);		
		}
		if(lookfors.length>1) {//判断是否有排序
			lookf1=lookfors[0];
			lookf2=lookfors[1];
		}
		
		Map<String, String> map = new HashMap<String, String>();// 将多参数存入map
		
		if("0".equals(lookfor)||"0".equals(lookf1)) {//查出全部书
			String sq="1";//sql语句值
			pageSql="01";//判断执行那种sql条件
			map.put("lookAll", sq+"");
			
		}if("07".equals(lookfor)) {//判断是否需要排序
			String sq="1";//sql语句值
			pageSql="11";//判断执行那种sql条件
			map.put("lookAll", sq+"");
		}
		
		if("3".equals(lookfor)||"3".equals(lookf1)) {//javascript类查找
			String sq="%"+"JavaScript"+"%";
			pageSql="03";//限制行数
			map.put("lookJs", sq);
			if(lookf2!=null&&"7".equals(lookf2)) {//判断是否需要排序
				String pageSql1="7";
				map.put("hasChang", pageSql1);
			}
		}
		
		if("4".equals(lookfor)) {//搜索查找类查找
			String sq="%"+keyword+"%";
			pageSql="04";//限制行数
			map.put("lookTap", sq);
		}
		if("5".equals(lookfor)) {//搜索查找类查找
			String sq="1";
			pageSql="04";//限制行数
			map.put("lookTap", sq);
		}
		map.put("lookAllsql", pageSql);
		totalCount=managedServlet.getPage(map);//获得总页数
		page=PageUtil.createPage(everyPage, totalCount, currentPage);//设置页数信息
		
		map.put("BeginIndex", page.getBeginIndex()+"");//设置开始与结束页
		map.put("EndIndex", page.getEndIndex()+"");
		books=managedServlet.getAllBook(map);//sql查询返回
		/**
		 * @author q1942
		 * @将页数当做参数传递
		 * @list:数据
		 * @page:页数
		 * **/
		List<Books> bookss=new ArrayList<Books>();
		//System.out.println("合计="+books+",page="+page+",totalCount="+totalCount);
		bookss=setBookMsgUtil.addPage(page,books,totalCount);//设置页码
		
		JSONArray jaArray=JSONArray.fromObject(bookss);//当做List存放,因为ajax时json类型,所有只能是对象或数组
		response.getWriter().print(jaArray.toString());
	}

}
