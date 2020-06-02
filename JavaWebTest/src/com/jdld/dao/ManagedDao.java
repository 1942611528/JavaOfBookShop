package com.jdld.dao;

import java.util.List;
import java.util.Map;

import com.jdld.entity.Books;
import com.jdld.entity.Manager;
import com.jdld.entity.ShoppMsg;

public interface ManagedDao {
	/**
	 * @验证管理员
	 **/
	Manager findManager(Map<String, String> map) throws Exception;

	// public Manager selectUser(@Param("adminname")String
	// username,@Param("adminpwd")String password);
	/**
	 * @param objects
	 * @param string
	 * @获取总信息数
	 **/
	int findBookPageAll(Map<String, String> map) throws Exception;

	/**
	 * @param listString
	 * @param string
	 * @查询所有书本
	 **/
	List<Books> findBook(Map<String, String> map) throws Exception;

	/**
	 * @获取购物车信息
	 * @param id
	 * @return
	 */
	List<ShoppMsg> findShopp(Map<String, String> map) throws Exception;

	/**
	 * @删除购物车指定信息
	 * @param uid
	 * @param bookname
	 * @return
	 */
	int deletShopp(Map<String, String> map) throws Exception;

	/**
	 * @根据Uid获取书本
	 * @param map
	 * @return
	 */
	Books findBookByUid(Map<String, String> map) throws Exception;

	/**
	 * @设置书本信息到购物车
	 * @param shoppMsg
	 */
	void insertBook(Map<String, String> map) throws Exception;

}
