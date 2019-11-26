package cn.zwqh.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zwqh.springboot.dao.UserDao;
import cn.zwqh.springboot.model.UserEntity;
import cn.zwqh.springboot.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	/**
	 * 保存用户
	 */
	@Override
	public void saveUser(UserEntity user) {
		userDao.insertUser(user);
	}

}
