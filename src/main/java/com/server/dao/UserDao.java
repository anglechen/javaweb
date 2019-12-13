/**
 * 
 */
package com.server.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.server.domain.User;

/**
 * @author Administrator
 *
 */
public interface UserDao {
	
	public List<User> selectAll(User user) throws SQLException;
	
	public User selectById(int id) throws SQLException, IllegalAccessException, InvocationTargetException;
	
	public User add(User user) throws SQLException;
	
	public void mod(User user) throws SQLException;
	
	public void del(int id) throws SQLException;
}
