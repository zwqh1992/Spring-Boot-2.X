package cn.zwqh.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello World";
	}
}
