/**
 *
 */
package com.server.utils;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @author Administrator
 * @date 2018年5月3日 下午6:26:16
 * 
 */
public class C3p0PoolUtilTest {

	@Test
	public void test() {
		for(int i = 0 ; i< 20; i++) {
			Connection conn = C3p0PoolUtil.getConnection();
			System.out.println(conn);
			if(i >= 9) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i);
		}
		
	}

}
