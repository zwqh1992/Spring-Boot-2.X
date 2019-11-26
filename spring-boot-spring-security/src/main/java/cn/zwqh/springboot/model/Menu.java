package cn.zwqh.springboot.model;

public class Menu extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4245833784962015367L;
	
	
	private String menuName;//菜单名称
	private String menuUrl;//Controller路径
	private String menuCode;//菜单编码
	private Long parentId;//父菜单ID
	private Integer menuType;//菜单类型：0-菜单1-按钮
	private Integer orderNum;//显示序号
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	
	
}
