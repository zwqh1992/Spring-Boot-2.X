package cn.zwqh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 用于不同权限页面访问测试
 * @author charlie
 *
 */
@Controller
public class ResourceController {

	@GetMapping("/publicResource")
	public String toPublicResource() {
		return "resource/public";
	}
	
	@GetMapping("/vipResource")
	public String toVipResource() {
		return "resource/vip";
	}
}
