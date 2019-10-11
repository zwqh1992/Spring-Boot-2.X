package cn.zwqh.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("cn.zwqh.springboot.dao")
@EnableWebMvc //启用 Spring MVC 配置
public class SpringBootSsmThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSsmThymeleafApplication.class, args);
	}

}
