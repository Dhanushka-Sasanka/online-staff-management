package com.osms.model;

public class User {

	private int userID;
	private String userName;
	private String password;
	private String userRole;

	public User(int userID, String userName, String password, String userRole) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole
				+ "]";
	}

}
