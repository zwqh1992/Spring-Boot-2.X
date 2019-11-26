package cn.zwqh.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
/**
 * 用于不同权限ajax请求测试
 * @author charlie
 *
 */
@RestController
@RequestMapping("/test")
public class HttptestController {

	@PostMapping("/public")
	public JSONObject doPublicHandler(Long id) {
		JSONObject json = new JSONObject();
		json.put("code", 200);
		json.put("msg", "请求成功" + id);
		return json;
	}

	@PostMapping("/vip")
	public JSONObject doVipHandler(Long id) {
		JSONObject json = new JSONObject();
		json.put("code", 200);
		json.put("msg", "请求成功" + id);
		return json;
	}
}
