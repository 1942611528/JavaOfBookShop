package com.jdld.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 工具类
 * @author Administrator
 *
 */
public class JdbcUtils {
	//把db.properties 文件中的数据加载到Properties类,   只需要加载一次
	//Properties类作为这个类的属性
	private static Properties props = new Properties();
	//作为属性
	private static Connection conn = null;
	private static PreparedStatement pstat = null;
	
	
	static{
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			//加载驱动类
			Class.forName(props.getProperty("driverClassName"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到连接对象
	 * @return
	 * @throws SQLException
	 */
	public static  Connection  getConnection() throws SQLException{
		conn = DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param rs   结果集
	 */
	public static void  close(ResultSet rs){
		try {
			if(rs != null) rs.close();
			if(pstat != null) {
				pstat.close();
				pstat = null; //还原初始值, 一定在close() 之后
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @ 执行增删改的sql语句
	 * @param sql  sql语句
	 * @param params  参数
	 * @return  所影响的行数
	 * 可变参数: 本质就是一个数组       没有传递值, 这个可变参数的值就是null   []
	 */
	public static int  executeUpdate(String sql,Object...params){
		try {
			conn = JdbcUtils.getConnection();
			pstat = conn.prepareStatement(sql);
			//给?赋值
			//params !=null 写前面?? 
			if(params !=null &&  params.length > 0 ){ //有值
				for (int i = 0; i < params.length; i++) {
					if(params[i] instanceof java.util.Date){
						java.util.Date hiredate = (java.util.Date)params[i];
						pstat.setDate(i+1, new java.sql.Date(hiredate.getTime()));

					}else{
						pstat.setObject(i+1, params[i]);
					}
				}
			}
			return pstat.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(null);
		}
	}
	
	//查询?  返回的是ResultSet    解析ResultSet 由调用者去处理
	public static ResultSet executeQuery(String sql,Object...params){
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			pstat = conn.prepareStatement(sql);
			//给?赋值
			//params !=null 写前面?? 
			if(params !=null &&  params.length > 0 ){ //有值
				for (int i = 0; i < params.length; i++) {
					pstat.setObject(i+1, params[i]);
				}
			}
			rs =  pstat.executeQuery();
			return rs;   // finally  在return 之前 执行, 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
