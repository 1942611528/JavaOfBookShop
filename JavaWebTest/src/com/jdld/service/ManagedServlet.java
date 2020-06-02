package com.jdld.service;

import java.util.List;
import java.util.Map;

import com.jdld.entity.Books;
import com.jdld.entity.Manager;
import com.jdld.entity.ShoppMsg;

public interface ManagedServlet {
	/**
	 * @查询管理员
	 **/
	Manager managerHas(Map<String, String> map);

	/**
	 * @param objects
	 * @param string @获取总页数(全部)
	 **/
	int getPage(Map<String, String> map);

	/**
	 * @param listString
	 * @param string
	 * @查询所有书本信息
	 **/
	List<Books> getAllBook(Map<String, String> map);

	/**
	 * @获取购物车信息
	 * @param id
	 * @return
	 */
	List<ShoppMsg> findShoppMsg(Map<String,String> map);

	/**
	 * @删除购物车指定信息
	 * @param uid
	 * @param bookname
	 * @return
	 */
	int deleShoppMsg(Map<String,String> map);

	/**
	 * @根据UID获取指定书本
	 * @param map
	 * @return
	 */
	Books getBookByUid(Map<String, String> map);

	/**
	 * @设置书本信息到购物车
	 * @param shoppMsg
	 */
	void setBookOfSp(Map<String, String> map);

}
