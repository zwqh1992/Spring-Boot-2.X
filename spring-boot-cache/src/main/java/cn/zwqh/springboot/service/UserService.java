package cn.zwqh.springboot.service;

import java.util.List;

import cn.zwqh.springboot.model.UserEntity;

public interface UserService {

	/**
	 * 查找所有
	 * @return
	 */
	List<UserEntity> getAll();
	/**
	 * 根据id获取用户
	 * @param id
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
	
	
	void deleteAll1();
	
	void deleteAll2();

}
