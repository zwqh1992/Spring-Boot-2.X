package cn.zwqh.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zwqh.springboot.dao.UserDao;
import cn.zwqh.springboot.model.UserEntity;

@RestController
public class LogController {

	private Logger log = LoggerFactory.getLogger(LogController.class);
	
	@Autowired
	private UserDao userDao;


	@GetMapping("/log")
	public String log() {
		String logLevel = "";
		if (log.isTraceEnabled()) {
			log.trace("5-TRACE");
			logLevel += "5-TRACE|";
		}
		if (log.isDebugEnabled()) {
			log.debug("4-DEBUG");
			logLevel += "4-DEBUG|";
		}
		if (log.isInfoEnabled()) {
			log.info("3-INFO");
			logLevel += "3-INFO|";
		}
		if (log.isWarnEnabled()) {
			log.warn("2-WARN");
			logLevel += "2-WARN|";
		}
		if (log.isErrorEnabled()) {
			log.error("1-ERROR");
			logLevel += "1-ERROR|";
		}
		return logLevel;
	}
	
	@GetMapping("/getAll")
	public List<UserEntity> getAll(){
		return userDao.getAll(); 
	}
}
