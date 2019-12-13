/**
 * 2018年5月3日 下午3:19:03
 * Administrator
 */
package com.server.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.server.domain.User;

/**
 * @author Administrator
 *
 */
public class JdbcBaseUtil {

	static {
		try {
			Class.forName(PropertiesUtil.getProps("jdbc.driver", null));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(PropertiesUtil.getProps("jdbc.url", null),
					PropertiesUtil.getProps("jdbc.username", null), PropertiesUtil.getProps("jdbc.password", null));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	/**
	 * 释放连接
	 * @param conn
	 * @param statement
	 */
	public static void releaseConnection(Connection conn,Statement statement) {
		if(conn == null)return;
		try {
			if(conn.isClosed())return;
			statement.close();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	//执行查询任务
	public static Boolean excute(String sql) throws SQLException {
		Connection conn = getconnection();
		Statement statement = conn.createStatement();
		Boolean result =  statement.execute(sql);
		statement.close();
		conn.close();
		return result;
	}
	
	//查询返回map对象
	public static List<Map<String, Object>>  excuteQuery(String sql) throws Exception {
		Connection conn = getconnection();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		ResultSetMetaData meteData = result.getMetaData();
		int cols = meteData.getColumnCount();
		List<Map<String, Object>> results = null;
		while (result.next()) {
			Map map =  new HashMap<>();
			for (int i = 1; i <= cols; i++) {
				map.put(meteData.getColumnLabel(i), result.getString(i));
			}
		}
		return results;
	}
	
	//把查询处理的记录转换为对应的class类对象（多条记录）
	public static  List<Object>  excuteQueryForObjects(String sql,Class clazz){
		Connection conn = getconnection();
		Statement statement = null;
		List<Object> results = new ArrayList<>();
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			ResultSetMetaData meteData = result.getMetaData();
			int cols = meteData.getColumnCount();
			while (result.next()) {
				Map map =  new HashMap<>();
				for (int i = 1; i <= cols; i++) {
					map.put(meteData.getColumnLabel(i), result.getString(i));
				}
				results.add(ConverUtil.mapToObjectBeanutils(map, clazz));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			releaseConnection(conn, statement);
		}
		
		return results;
	}
	
	//把查询处理的记录转换为对应的class类对象（单个记录，比较按id查询）
	public static  Object  excuteQueryForObject(String sql,Class clazz) {
		Connection conn = getconnection();
		Statement statement = null;
		Object obj = null;
		try {
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			ResultSetMetaData meteData = result.getMetaData();
			int cols = meteData.getColumnCount();
			while (result.next()) {
				Map map =  new HashMap<>();
				for (int i = 1; i <= cols; i++) {
					map.put(meteData.getColumnLabel(i), result.getString(i));
				}
				obj = ConverUtil.mapToObjectBeanutils(map, clazz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			releaseConnection(conn, statement);
		}
		return obj;
	}
}
