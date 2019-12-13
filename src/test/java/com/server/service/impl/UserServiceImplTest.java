/**
 *
 */
package com.server.service.impl;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.junit.Test;
import com.server.dao.UserDao;
import com.server.dao.impl.UserDaoImpl;
import com.server.domain.User;
import com.server.service.UserService;

/**
 * @author Administrator
 * @date 2018年6月12日 下午2:35:17
 * 
 */
public class UserServiceImplTest {

	@Test
	public void testSpringBean() throws IllegalAccessException, InvocationTargetException, SQLException  {
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("application.xml");
//		UserService userService = (UserService) beanFactory.getBean("userService");
//		System.out.println(userService);
//		User user = userService.selectById(57);
//		System.out.println(user);
		
		
	}
	
	
	
	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectById() {
		fail("Not yet implemented");
	}
	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testMod() {
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

}
