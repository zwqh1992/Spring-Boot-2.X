package cn.zwqh.springboot.dao;

import java.util.List;

import cn.zwqh.springboot.model.UserEntity;

public interface UserDao {
	//mapper.xml方式 
	/**
	 * 获取所有用户
	 * @return
	 */
	List<UserEntity> getAll();
	/**
	 * 根据id获取用户
	 * @return
	 */
	UserEntity getOne(Long id);
	/**
	 * 新增用户
	 * @param user
	 */
	void insertUser(UserEntity user);
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUser(UserEntity user);
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Long id);
		

}
