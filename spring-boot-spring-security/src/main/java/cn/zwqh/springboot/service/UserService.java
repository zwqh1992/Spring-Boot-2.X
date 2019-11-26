package cn.zwqh.springboot.service;

import cn.zwqh.springboot.model.UserEntity;

public interface UserService {
	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(UserEntity user);

}
