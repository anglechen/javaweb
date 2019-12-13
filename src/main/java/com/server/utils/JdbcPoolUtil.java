/**
 *
 */
package com.server.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @date 2018年5月3日 下午4:51:39
 * 
 */
public class JdbcPoolUtil {
	
	private final static int INIT_COUNT = 5;
	
	private  static int CURRENT_COUNT = 0;
	
	private final static int MAX_COUNT = 50;
	
	private final static Lock lock = new ReentrantLock();
	
	private static Condition notEmpty  = lock.newCondition();
	
	private static Condition notFull  = lock.newCondition();
	
	private final static String url = PropertiesUtil.getProps("jdbc.url", null);
	private final static String usename = PropertiesUtil.getProps("jdbc.username", null);
	private final static String password = PropertiesUtil.getProps("jdbc.password", null);
	
	
	private static LinkedList<Connection> connections = new LinkedList<Connection>();
	
	static {
		//加载驱动
		try {
			Class.forName(PropertiesUtil.getProps("jdbc.driver", null));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//初始化数据库连接
		for(int i = 0 ; i< INIT_COUNT ; i++) {
			createConnection();
		};
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws InterruptedException
	 */
	public static Connection getConnection(){
		lock.lock();
		if(connections.isEmpty()) {
			if(CURRENT_COUNT < MAX_COUNT) {
				createConnection();
			}else {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Connection conn = connections.removeFirst();
		notFull.signalAll();
		lock.unlock();
		return conn;
	}
	
	private static void createConnection() {
		try {
			connections.add(DriverManager.getConnection(url,usename, password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CURRENT_COUNT++;
	}
	
	/**
	 * 释放连接
	 * @param conn
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void release(Connection conn) throws SQLException, InterruptedException {
		lock.lock();
		//如果连接无效就新建连接进去
		if(conn == null || conn.isClosed() ) {
			createConnection();
			notEmpty.signalAll();
			lock.unlock();
			return;
		}
		//常规的把连接释放到连接池中
		conn.setAutoCommit(true);
		connections.add(conn);
		notEmpty.signalAll();
		lock.unlock();
	}
}
