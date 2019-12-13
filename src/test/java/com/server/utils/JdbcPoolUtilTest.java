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
 * @date 2018年5月3日 下午5:23:38
 * 
 */
public class JdbcPoolUtilTest {

	@Test
	public void test() {
		for(int i = 0 ; i < 1000; i++) {
			Connection conn = JdbcPoolUtil.getConnection();
			System.out.println(conn);
			if(i>48) {
				try {
					JdbcPoolUtil.release(conn);
					System.out.println("=====release" + i);
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			System.out.println("=====" + i);
		}
		
	}

}
