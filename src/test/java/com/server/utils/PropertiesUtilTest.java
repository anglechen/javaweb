/**
 *
 */
package com.server.utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Administrator
 * @date 2018年5月3日 下午3:33:34
 * 
 */
public class PropertiesUtilTest {

	@Test
	public void test() {
		System.out.println(PropertiesUtil.getProps("jdbc.connection.password",null));
		System.out.println(PropertiesUtil.getProps("jdbc.connection.password","jdbc.properties"));
		System.out.println(PropertiesUtil.getProps("jdbc.connection.password2","jdbc2.properties"));
	}

}
