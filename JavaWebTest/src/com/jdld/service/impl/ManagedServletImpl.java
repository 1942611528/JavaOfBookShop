package com.jdld.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.jdld.dao.ManagedDao;
import com.jdld.entity.Books;
import com.jdld.entity.Manager;
import com.jdld.entity.ShoppMsg;
import com.jdld.service.ManagedServlet;
import com.jdld.util.getSessionUtil;

public class ManagedServletImpl implements ManagedServlet {
	public getSessionUtil getsession = new getSessionUtil();// 配置加载工具类

	/**
	 * @登录检查
	 */
	@Override
	public Manager managerHas(Map<String, String> map) {
		SqlSession sqlSession = getsession.getSession();
		ManagedDao manageDao = sqlSession.getMapper(ManagedDao.class);
		try {
			return manageDao.findManager(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @获取页数
	 **/
	@Override
	public int getPage(Map<String, String> map) {
		SqlSession sqlSession = getsession.getSession();
		ManagedDao manageDao = sqlSession.getMapper(ManagedDao.class);
		try {
			return manageDao.findBookPageAll(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @查询所有书本
	 **/
	@Override
	public List<Books> getAllBook(Map<String, String> map) {
		SqlSession sqlSession = getsession.getSession();
		ManagedDao manageDao = sqlSession.getMapper(ManagedDao.class);
		try {
			return manageDao.findBook(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @获取购物车信息
	 */
	@Override
	public List<ShoppMsg> findShoppMsg(Map<String, String> map) {
		SqlSession sqlSession = getsession.getSession();
		ManagedDao manageDao = sqlSession.getMapper(ManagedDao.class);
		try {
			return manageDao.findShopp(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @删除购物车指定信息
	 */
	@Override
	public int deleShoppMsg(Map<String, String> map) {
		SqlSession sqlSession = getsession.getSession();
		ManagedDao manageDao = sqlSession.getMapper(ManagedDao.class);
		try {
			return manageDao.deletShopp(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @根据UID获取书本
	 */
	@Override
	public Books getBookByUid(Map<String, String> map) {
		SqlSession sqlSession = getsession.getSession();
		ManagedDao manageDao = sqlSession.getMapper(ManagedDao.class);
		try {
			return manageDao.findBookByUid(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @设置书本信息到购物车
	 */
	@Override
	public void setBookOfSp(Map<String, String> map) {
		SqlSession sqlSession = getsession.getSession();
		ManagedDao manageDao = sqlSession.getMapper(ManagedDao.class);
		try {
			manageDao.insertBook(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
