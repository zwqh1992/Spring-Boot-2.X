package cn.zwqh.springboot.service.impl;

import org.springframework.stereotype.Service;

import cn.zwqh.springboot.service.TestService;
@Service
public class TestServiceImpl implements TestService{

	@Override
	public void doTest() {
		int x = 1 / 0;
	}

}
