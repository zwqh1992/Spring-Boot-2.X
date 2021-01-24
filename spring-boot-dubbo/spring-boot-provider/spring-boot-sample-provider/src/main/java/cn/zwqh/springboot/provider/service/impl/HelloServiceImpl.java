package cn.zwqh.springboot.provider.service.impl;

import cn.zwqh.springboot.api.IHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

import javax.naming.Name;

/**
 * @program: spring-boot-dubbo
 * @description: hello service impl
 * @author: 朝雾轻寒
 * @create: 2021-01-24 13:34
 **/
@DubboService
public class HelloServiceImpl implements IHelloService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s]：hello,%s", serviceName, name);
    }
}
