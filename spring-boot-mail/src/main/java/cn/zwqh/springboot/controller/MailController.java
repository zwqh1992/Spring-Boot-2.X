package cn.zwqh.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zwqh.springboot.common.MailTool;
@RestController
public class MailController {

	@Autowired
	private MailTool mailTool;
	
	@RequestMapping("/send")
	public String send() {
		mailTool.send();
		return "send success";
	}
	
	@RequestMapping("/sendHtml")
	public String sendHtml() {
		mailTool.sendHtml();
		return "sendHtml success";
	}
	
	@RequestMapping("/sendHtmlWithAttach")
	public String sendHtmlWithAttach() {
		mailTool.sendHtmlWithAttach();
		return "sendHtmlWithAttach success";
	}
	
	
}
