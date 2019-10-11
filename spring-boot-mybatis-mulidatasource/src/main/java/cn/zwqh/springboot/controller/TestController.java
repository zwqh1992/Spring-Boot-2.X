package cn.zwqh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import cn.zwqh.springboot.dao.master.UserDao;
import cn.zwqh.springboot.dao.slave.HeroDao;
import cn.zwqh.springboot.model.Hero;
import cn.zwqh.springboot.model.UserEntity;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private HeroDao heroDao;
	
	/**
	 *  查找所有用户
	 * @return
	 */
	@RequestMapping("/getAllUser")
	public List<UserEntity> getAllUser(){
		return userDao.getAll(); 
	}
	/**
	 *  查找所有英雄
	 * @return
	 */
	@RequestMapping("/getAllHero")
	public List<Hero> getAllHero(){
		return heroDao.getAllHero();
	}
	
}
