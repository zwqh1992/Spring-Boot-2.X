package cn.zwqh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.zwqh.springboot.model.UserEntity;
import cn.zwqh.springboot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public ModelAndView showUserList(int pageNum, int pageSize) {
		PageInfo<UserEntity> pageInfo = userService.getUserList(pageNum, pageSize);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}

}
