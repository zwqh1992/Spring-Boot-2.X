package cn.zwqh.springboot.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9005214545793249372L;

	private Long id;// 用户id
	private String username;// 用户名
	private String password;// 密码
	private List<Role> userRoles;// 用户权限集合
	private List<Menu> roleMenus;// 角色菜单集合

	private Collection<? extends GrantedAuthority> authorities;
	public UserEntity() {
		
	}
	
	public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities,
			List<Menu> roleMenus) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.roleMenus = roleMenus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public List<Menu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(List<Menu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
