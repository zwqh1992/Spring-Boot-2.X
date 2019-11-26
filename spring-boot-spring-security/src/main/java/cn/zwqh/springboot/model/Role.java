package cn.zwqh.springboot.model;

public class Role extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3572463217368803762L;
	private String roleName;// 角色名称
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
