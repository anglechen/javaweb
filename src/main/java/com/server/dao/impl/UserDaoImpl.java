/**
 *
 */
package com.server.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.server.dao.UserDao;
import com.server.domain.User;
import com.server.utils.ConverUtil;
import com.server.utils.JdbcBaseUtil;

/**
 * @author Administrator
 * @date 2018年5月4日 上午10:07:28
 * 
 */
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectAll(User user) throws SQLException {
		Connection conn = JdbcBaseUtil.getconnection();
		Statement statement = conn.createStatement();
		List<User> results = new ArrayList<>();
		String sql = "select "
				+ "	id, real_name as realName,sex ,age,addr,"
				+ " user_name as userName ,"
				+ "img, password,phone,status,remarks,cre_time as creTime ," 
				+ "mod_time as modTime ,cre_user as creUser ,mod_user as modUser,"
				+ "cre_user_name as creUserName ,mod_user_name as modUserName "
				+ "from sys_user u  where 1 = 1";
		if(user.getRealName() != null ) {
			sql += " and user_name like '%"+ user.getRealName() + "%' ";
		}
		if(user.getSex() != null ) {
			sql += " and sex ="+ user.getSex() ;
		}
		if(user.getAge() != null ) {
			sql += " and age = "+ user.getAge() ;
		}
		if(user.getAddr() != null ) {
			sql += " and addr like '%"+ user.getAddr() +"%' ";
		}
		if(user.getRemarks() != null ) {
			sql += " and remarks like  '%"+ user.getRemarks() +"%' ";
		}
		ResultSet result = statement.executeQuery(sql);
		ResultSetMetaData meteData = result.getMetaData();
		int columnCount = meteData.getColumnCount();
		while (result.next()) {
			Map userMap =  new HashMap<>();
			for (int i = 1; i <= columnCount; i++) {
				userMap.put(meteData.getColumnLabel(i), result.getString(i));
			}
			User innerUser = new User();
			ConverUtil.transMap2Bean(userMap, innerUser);
			results.add(innerUser);
		}
		statement.close();
		conn.close();
		return results;
	}
	
	public List<Object> selectAllByDefault() {
		String sql = "select "
				+ "	id, real_name as realName, sex ,age,addr,"
				+ " user_name as userName ,"
				+ "img, password,phone,status,remarks,cre_time as creTime ," 
				+ "mod_time as modTime ,cre_user as creUser ,mod_user as modUser,"
				+ "cre_user_name as creUserName ,mod_user_name as modUserName "
				+ "from sys_user u ";
		List<Object> results = JdbcBaseUtil.excuteQueryForObjects(sql, User.class);
		return results;
		
	}

	@Override
	public User selectById(int id) throws SQLException, IllegalAccessException, InvocationTargetException {
		Connection conn = JdbcBaseUtil.getconnection();
		Statement statement = conn.createStatement();
		String sql = "select "
				+ "	id, real_name as realName,sex ,age,addr,"
				+ " user_name as userName ,"
				+ "img, password,phone,status,remarks,cre_time as creTime ," 
				+ "mod_time as modTime ,cre_user as creUser ,mod_user as modUser,"
				+ "cre_user_name as creUserName ,mod_user_name as modUserName "
				+ "from sys_user u where u.id =" + id;
		ResultSet result = statement.executeQuery(sql);
		ResultSetMetaData meteData = result.getMetaData();
		Map userMap =  new HashMap<>();
		java.sql.Date date = null;
		while (result.next()) {
			for (int i = 1; i <= 14; i++) {
				userMap.put(meteData.getColumnLabel(i), result.getString(i));
			}
		}
		statement.close();
		conn.close();
		User user = new User();
		ConverUtil.transMap2Bean(userMap, user);
		return user;
	}

	@Override
	public User add(User user) throws SQLException {
		Connection conn = JdbcBaseUtil.getconnection();
		Statement statement = conn.createStatement();
		String sql = "insert into sys_user( "
				+ "real_name, user_name,sex ,age,addr,"
				+ "img, password,phone,status,remarks,cre_time ) values ('"
				+  user.getRealName() + "','" + user.getUserName() + "'," + user.getSex() +","
				+  user.getAge() + ",'"+user.getAddr() +"','"
				+  user.getImg()  + "','" + user.getPassword()  + "','" + user.getPhone() 
				+ "'," + user.getStatus()  + ",'" + user.getRemarks()  + "', now()"
				+ ")";
		System.out.println(sql);
		statement.execute(sql);
		statement.close();
		conn.close();
		return user;
	}

	@Override
	public void mod(User user) throws SQLException {
		Connection conn = JdbcBaseUtil.getconnection();
		Statement statement = conn.createStatement();
		String sql = "update  sys_user set real_name = '" + user.getRealName() +"' , user_name ='"
				+ user.getUserName() +"', sex=" +user.getSex() +", age = "+ user.getAge() +", addr= '" + user.getAddr() 
				+"' , img = '"+ user.getImg() +"' ,password = '"+ user.getPassword()
				+ "' ,phone  = '"+user.getPhone() +"' ,status = "+ user.getStatus() 
				+ " ,remarks ='"+user.getRemarks() +"' where id =" + user.getId();
		System.out.println(sql);
		statement.execute(sql);
		statement.close();
		conn.close();
	}

	@Override
	public void del(int id) throws SQLException {
		Connection conn = JdbcBaseUtil.getconnection();
		Statement statement = conn.createStatement();
		String sql = "delete from  sys_user where id =" + id;
		System.out.println(sql);
		statement.execute(sql);
		statement.close();
		conn.close();
	}

}
