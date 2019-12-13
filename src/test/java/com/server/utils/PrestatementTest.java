/**
 *
 */
package com.server.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author Administrator
 * @date 2018年5月7日 下午9:23:14
 * 
 */
public class PrestatementTest {
	
	@Test
	public void TestPrestatement() {
		Connection conn = JdbcBaseUtil.getconnection();
		Statement sm = null;
		
		try {
			 sm = conn.createStatement();
			 conn.setAutoCommit(false);
			 sm.addBatch("insert into sys_user(user_name) values('sdaf')");
			 sm.addBatch("insert into sys_user(user_name) values('sdaf222')");
//			sm.execute("insert into sys_user(user_name) values('sdaf')");
			PreparedStatement prestate = conn.prepareStatement("insert into sys_user(user_name) values(?)");
//			prestate.setInt(1, 2);
			prestate.setString(1, "测试1");
//			prestate.setBinaryStream(parameterIndex, x);
			prestate.addBatch();
//			prestate.setInt(1, 2);
			prestate.setString(1, "测试2");
			prestate.addBatch();
//			ResultSet result = prestate.executeUpdate()
//			if(result.wasNull())throw new NullPointerException();
//			while(result.next()) {
//				System.out.println(result.getString(1));
//			}
//			int i = prestate.executeUpdate();
//			if(i == 1) {
//				throw new NullPointerException();
//			}
			 sm.executeBatch();
			 prestate.executeBatch();
//			throw new RuntimeException();
			
		} catch (Exception e) {
			e.printStackTrace();
//			try {
//				conn.rollback();
//				System.out.println("rollback");
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sm.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
