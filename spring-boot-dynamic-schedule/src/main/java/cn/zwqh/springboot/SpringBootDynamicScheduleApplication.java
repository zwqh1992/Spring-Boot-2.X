package cn.zwqh.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("cn.zwqh.springboot.dao")
@EnableScheduling
public class SpringBootDynamicScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDynamicScheduleApplication.class, args);
	}

}
