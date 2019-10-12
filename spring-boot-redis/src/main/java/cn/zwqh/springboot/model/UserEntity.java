package cn.zwqh.springboot.model;

import java.io.Serializable;

public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237730257103305078L;
	
	private Long id;
	private String userName;
	private String userSex;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
}
