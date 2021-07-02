package cn.zwqh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringBootShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShardingsphereApplication.class, args);
    }

}
