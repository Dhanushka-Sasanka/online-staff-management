package com.osms.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.osms.model.User;

public interface UserService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(UserService.class.getName());

	/**
	 * Add User for User table
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean addUser(User user) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get a particular User
	 *
	 * @param empoyeeID
	 * @return User
	 */
	public User getUserByID(int userID) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get all list of User
	 *
	 * @return ArrayList<User>
	 */
	public List<User> getUsers() throws FileNotFoundException, SQLException, Exception;

	/**
	 * Update existing User
	 * 
	 * @param userID
	 * @param user
	 *
	 * @return boolean 
	 */
	public boolean updateUser(int userID, User user) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Remove existing User
	 * @param userID
	 * @return boolean
	 */
	public boolean removeUser(int userID) throws FileNotFoundException, SQLException, Exception;
	
	/**
	 * Getting next ID 
	 * @return String
	 */
	public String getNextID()throws Exception;
	
	/**
	 * Getting All IDs 
	 * @return List<String>
	 */
	public List<String> getAllUserIDs()throws Exception;
	
	/**
	 * getting existing User
	 * @param userName
	 * @param password
	 * @return boolean
	 */
	public User getUserAuthority(String userName , String password ) throws FileNotFoundException, SQLException, Exception;

	/**
	 * getting existing User count
	 */
    int getAllUsersCount() throws Exception;
}
