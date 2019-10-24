package cn.zwqh.springboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zwqh.springboot.model.UserEntity;

@RestController
public class TestController {

	@GetMapping("/hello")
	public UserEntity getHello(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println("这里是TestController");
		UserEntity user=new UserEntity();
		user.setId(1L);
		user.setUserName("zwqh");
		user.setUserSex("男");
		return user;
	}
}
