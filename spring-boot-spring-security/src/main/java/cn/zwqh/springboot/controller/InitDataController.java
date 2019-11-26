package cn.zwqh.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zwqh.springboot.model.UserEntity;
import cn.zwqh.springboot.service.UserService;

@Controller
public class InitDataController {
	@Autowired
	private UserService userService;
	/**
	 * 初始化用户数据
	 */
	@RequestMapping("/initUserData")
	public @ResponseBody String initUserData() {
		//普通用户
		UserEntity user=new UserEntity();
		user.setUsername("user");
		user.setPassword(new BCryptPasswordEncoder().encode("user"));
		userService.saveUser(user);
		//管理员
		UserEntity admin=new UserEntity();
		admin.setUsername("admin");
		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
		userService.saveUser(admin);
		
		return "success";
	}
}
