package cn.zwqh.springboot.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserEntity", description = "用户对象")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237730257103305078L;
	@ApiModelProperty(value ="用户id",name="id",dataType="Long",required = false,example = "1",hidden = false )
	private Long id;
	@ApiModelProperty(value ="用户名",name="userName",dataType="String",required = false,example = "关羽" )
	private String userName;
	@ApiModelProperty(value ="用户性别",name="userSex",dataType="String",required = false,example = "男" )
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
