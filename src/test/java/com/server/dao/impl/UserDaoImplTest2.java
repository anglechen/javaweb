/**
 *
 */
package com.server.dao.impl;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.server.dao.UserDao;
import com.server.domain.User;

/**
 * @author Administrator
 * @date 2018年5月4日 下午12:04:13
 * 
 */
public class UserDaoImplTest2 {

	@Test
	public void testSelectAll() throws SQLException {
		UserDao userdao = new UserDaoImpl();
		List<User> users = userdao.selectAll(new User());
		for(User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void testSelectById() throws IllegalAccessException, InvocationTargetException, SQLException {
		UserDao userdao = new UserDaoImpl();
		User user = userdao.selectById(9);
		System.out.println(user);
	}

	@Test
	public void testAdd() throws SQLException {
		UserDao userdao = new UserDaoImpl();
		User user = new User();
		user.setRealName("张三");
		user.setUserName("test");
		user.setImg("/22");
		user.setPassword("12345678");
		user.setPhone("13245678765");
		user.setStatus(1);
		user.setRemarks("测试");
		userdao.add(user);
	}
	
	@Test
	public void testSelectAllByDefault() {
		UserDaoImpl userdao = new UserDaoImpl();
		List<Object> users = userdao.selectAllByDefault();
		for(Object u : users) {
			User user = (User) u;
			System.out.println(user);
		}
		
	}
	

	@Test
	public void testMod() throws SQLException {
		UserDao userdao = new UserDaoImpl();
		User user = new User();
		user.setRealName("张三士大夫撒大苏打发");
		user.setUserName("test");
//		user.setImg("/22");
		user.setPassword("12345678");
		user.setPhone("13245678765");
		user.setStatus(1);
		user.setRemarks("测试");
		user.setId(8);
		userdao.mod(user);
	}

	@Test
	public void testDel() throws IllegalAccessException, InvocationTargetException, SQLException {
		UserDao userdao = new UserDaoImpl();
		userdao.del(1);
	}

}
