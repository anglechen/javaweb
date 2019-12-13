/**
 *
 */
package com.server.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Administrator
 * @date 2018年5月3日 下午6:19:35
 * 
 */
public class C3p0PoolUtil {
	
	private static ComboPooledDataSource dataSource;
	
	private final static String driver = PropertiesUtil.getProps("jdbc.driver", null);
	private final static String url = PropertiesUtil.getProps("jdbc.url", null);
	private final static String usename = PropertiesUtil.getProps("jdbc.username", null);
	private final static String password = PropertiesUtil.getProps("jdbc.password", null);
	static {
		initDatasource();
	}
	
	public static void initDatasource() {
		 //第一步：创建连接池核心工具类
        dataSource=new ComboPooledDataSource();
        //第二步：连接池，url，驱动，账号，密码，初始连接数，最大连接数
        dataSource.setJdbcUrl(url);//设置url
        try {
			dataSource.setDriverClass(driver);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//设置驱动
        dataSource.setUser(usename);//mysql的账号
        dataSource.setPassword(password);//mysql的密码
       
        
        dataSource.setInitialPoolSize(6);//初始连接数，即初始化6个连接
        dataSource.setMaxPoolSize(10);//最大连接数，即最大的连接数是50
        dataSource.setMaxIdleTime(60);//最大空闲时间
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
