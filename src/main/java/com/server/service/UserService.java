/**
 *
 */
package com.server.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.server.domain.User;

/**
 * @author Administrator
 * @date 2018年5月4日 下午1:41:13
 * 
 */
public interface UserService {
	
	public List<User> selectAll(User user) throws SQLException;
	
	public User selectById(int id) throws IllegalAccessException, InvocationTargetException, SQLException;
	
	public User add(User user) throws SQLException;
	
	public void mod(User user) throws SQLException;
	
	public void del(int id) throws SQLException;
}
