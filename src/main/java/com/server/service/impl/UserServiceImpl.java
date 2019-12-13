/**
 *
 */
package com.server.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.server.dao.UserDao;
import com.server.dao.impl.UserDaoImpl;
import com.server.domain.User;
import com.server.service.UserService;

/**
 * @author Administrator
 * @date 2018年5月4日 下午2:25:41
 * 
 */
public class UserServiceImpl implements UserService {
	
	private  UserDao userDao2 = new UserDaoImpl();
	
	
	
	public UserDao getUserDao() {
		return userDao2;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao2 = userDao;
	}

	@Override
	public List<User> selectAll(User user) throws SQLException {
		return userDao2.selectAll(user);
	}

	@Override
	public User selectById(int id) throws IllegalAccessException, InvocationTargetException, SQLException {
		return userDao2.selectById(id);
	}

	@Override
	public User add(User user) throws SQLException {
		return userDao2.add(user);
	}

	@Override
	public void mod(User user) throws SQLException {
		 userDao2.mod(user);
	}

	@Override
	public void del(int id) throws SQLException {
		userDao2.del(id);
	}

}
