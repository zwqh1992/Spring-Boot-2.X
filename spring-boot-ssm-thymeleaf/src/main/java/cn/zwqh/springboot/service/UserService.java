package cn.zwqh.springboot.service;

import com.github.pagehelper.PageInfo;

import cn.zwqh.springboot.model.UserEntity;

public interface UserService {

	PageInfo<UserEntity> getUserList(int pageNum, int pageSize);

}
