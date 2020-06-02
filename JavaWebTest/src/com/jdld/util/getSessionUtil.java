package com.jdld.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class getSessionUtil {
	public SqlSession getSession() {
		String resource = "mybatis-config.xml";// mybatis配置文件
		InputStream inputStream = null;// 得到配置文件流
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);// 创建会话工厂,传入MyBatis配置信息
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
