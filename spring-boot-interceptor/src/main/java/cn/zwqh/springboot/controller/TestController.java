package cn.zwqh.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/hello")
	public String getHello() {
		System.out.println("这里是Hello");
		return "hello world";
	}
	
	
	@RequestMapping("/test1")
	public String getTest1() {
		System.out.println("这里是Test1");
		return "test1 content";
	}
	
	@RequestMapping("/test2")
	public String getTest2() {
		System.out.println("这里是Test2");
		return "test2 content";
	}
	
	@RequestMapping("/page")
	public String getPage(int pageNum,int pageSize) {
		System.out.println("页码："+pageNum);
		System.out.println("页码大小："+pageSize);
		return "test2 content";
	}
}
