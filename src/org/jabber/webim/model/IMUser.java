package org.jabber.webim.model;

public class IMUser {
	
	private String username;
	private String password;
	private String realname;
	private String email;
	private String group;
	
	private boolean isgroupadmin; 
	
	
	
	public IMUser() {}
	
	/**
	 * 实例化即时通讯用户
	 * @param username 用户名
	 * @param password 密码
	 * @param realname 真实姓名
	 * @param email 邮箱
	 * @param group 所在组名
	 * @param isgroupadmin 是否组管理员
	 */
	public IMUser(String username, String password, String realname, String email, String group, boolean isgroupadmin) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.email = email;
		this.group = group;
		this.isgroupadmin = isgroupadmin;
	}
	
	public boolean isIsgroupadmin() {
		return isgroupadmin;
	}
	public void setIsgroupadmin(boolean isgroupadmin) {
		this.isgroupadmin = isgroupadmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
}
