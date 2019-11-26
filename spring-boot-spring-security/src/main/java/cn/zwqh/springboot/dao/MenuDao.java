package cn.zwqh.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zwqh.springboot.model.Menu;
import cn.zwqh.springboot.model.Role;

public interface MenuDao {

	/**
	 * 根据角色获取菜单列表
	 * @param roles
	 * @return
	 */
	List<Menu> getRoleMenuByRoles(@Param("roles")List<Role> roles);

}
