package cn.zwqh.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/main")
	public ModelAndView toMainPage() {
		//获取登录的用户名
		Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=null;
		if(principal instanceof UserDetails) {
			username=((UserDetails)principal).getUsername();
		}else {
			username=principal.toString();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("username", username);
		return mav;
	}
	
	@GetMapping("/home")
	public String toHome() {
		return "home";
	}
	
	@GetMapping("/error")
	public String toErrorPage() {
		return "error/error";
	}
}
