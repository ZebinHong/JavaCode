package com.java1234.model;

/**
 * 用户实体
 * @author 86150
 *
 */
public class User {
	
	public User() {
		super();
	}
	
	public User(String userName, String password) {
		super();
		this.password = password;
		this.userName = userName;
	}

	private int id;  //编号
	private String password; //密码
	private String userName; //用户名
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
