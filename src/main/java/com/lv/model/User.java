package com.lv.model;

/**
 * 用户类
 *
 * @author lv
 */
public class User {

	/**
	 * 用户编号
	 */
	private int id;

	/**
	 * 用户名称
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String pasword;

	/**
	 * 用户投票资格
	 */
	private boolean qualification;

	public User(int id, String username, String pasword, boolean qualification) {
		this.id = id;
		this.username = username;
		this.pasword = pasword;
		this.qualification = qualification;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public boolean getQualification() {
		return qualification;
	}

	public void setQualification(boolean qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", pasword='" + pasword + '\'' +
				", qualification=" + qualification +
				'}';
	}
}
