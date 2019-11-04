package cn.zwqh.springboot.dao;

import java.util.List;

import cn.zwqh.springboot.model.UserEntity;

public interface UserDao {
	/**
	 * 获取所有用户
	 * @return
	 */
	List<UserEntity> getAll();
	
	
	
	

}
