package cn.zwqh.springboot.controller;

import javax.naming.NoPermissionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cn.zwqh.springboot.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	/**
	 * controller异常 测试
	 * 
	 * @return
	 */
	@GetMapping("/index")
	public String index() {
		int x = 1 / 0;
		return "hello";
	}

	/**
	 * service 异常测试
	 * 
	 * @return
	 */
	@GetMapping("/hello")
	public String hello() {
		testService.doTest();
		return "hello";
	}

	@GetMapping("/test")
	public String test() {
		String[] ss = new String[] { "1", "2" };
		System.out.print(ss[2]);
		return "hello";
	}

}
