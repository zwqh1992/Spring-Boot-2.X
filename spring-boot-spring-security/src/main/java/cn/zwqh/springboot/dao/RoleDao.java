package cn.zwqh.springboot.dao;

import java.util.List;

import cn.zwqh.springboot.model.Role;

public interface RoleDao {
	/**
	 * 根据用户id获取用户
	 * @param id
	 * @return
	 */
	List<Role> getUserRoleByUserId(Long id);

}
