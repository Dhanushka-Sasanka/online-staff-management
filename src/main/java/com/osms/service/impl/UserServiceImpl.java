package com.osms.service.impl;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osms.model.User;
import com.osms.service.UserService;
import com.osms.util.Constants;
import com.osms.util.CrudUtil;
import com.osms.util.IDGenerator;

public class UserServiceImpl implements UserService {

	@Override
	public boolean addUser(User user) throws FileNotFoundException, SQLException, Exception {
		String sql = "INSERT into users(username,password, userrole) values(?,?,?)";
		return CrudUtil.executeUpdate(sql,  user.getUserName(), user.getPassword(),
				user.getUserRole());
	}

	@Override
	public User getUserByID(int userID) throws FileNotFoundException, SQLException, Exception {
		User user = null;
		String sql = "select * from users where userid = ? ";
		System.out.println(sql);
		ResultSet rst = CrudUtil.executeQuery(sql, userID);
		while (rst.next()) {
			user = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4));
		}
		return user;
	}

	@Override
	public List<User> getUsers() throws FileNotFoundException, SQLException, Exception {
		List<User> users = new ArrayList<>();

		String sql = "SELECT *  from users ORDER BY convert(userID, DECIMAL)";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4)));
		}
		return users;
	}

	@Override
	public boolean updateUser(int userID, User user) throws FileNotFoundException, SQLException, Exception {
		String sql = "UPDATE users set username = ? , password = ? , userrole = ? where userID = ?";
		return CrudUtil.executeUpdate(sql, user.getUserName() , user.getPassword(),user.getUserRole()
				 , userID);
	}

	@Override
	public boolean removeUser(int userID) throws FileNotFoundException, SQLException, Exception {
		String sql = "DELETE from users where userID = ?";
		return CrudUtil.executeUpdate(sql, userID);
	}

	@Override
	public String getNextID() throws Exception {
		List<String> AttendanceIds = getAllUserIDs();
		return IDGenerator.generateIDs(AttendanceIds, Constants.SALARY_ID_PREFIX);
	}

	@Override
	public List<String> getAllUserIDs() throws Exception {
		List<String> AttendanceIds = new ArrayList<>();

		String sql = "SELECT userID from users";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			AttendanceIds.add(rst.getString(1));
		}
		return AttendanceIds;
	}

	@Override
	public User getUserAuthority(String userName, String password)
			throws FileNotFoundException, SQLException, Exception {
		String sql = "SELECT * FROM Users WHERE username = ? AND PASSWORD = ?";
		ResultSet rst =  CrudUtil.executeQuery(sql, userName , password);
		User user = null;
		if(rst.next()) {
			user = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4));
		}
		return user ;
	}


}
