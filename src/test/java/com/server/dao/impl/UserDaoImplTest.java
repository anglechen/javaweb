/**
 *
 */
package com.server.dao.impl;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.junit.Test;

import com.server.dao.UserDao;
import com.server.domain.User;

/**
 * @author Administrator
 * @date 2018年5月4日 上午10:15:56
 * 
 */
public class UserDaoImplTest {

	/**
	 * Test method for {@link com.server.dao.impl.UserDaoImpl#selectById(int)}.
	 * @throws SQLException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testSelectById() throws SQLException, IllegalAccessException, InvocationTargetException {
		UserDao userdao = new UserDaoImpl();
		User user = userdao.selectById(1);
		System.out.println(user);
	}

	
}
