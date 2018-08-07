package com.springboot.redis2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.redis2.service.RedisService;

@RestController
public class DemoController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping(value="/test")
	public void demoTest() {
		redisService.set("first-test1", "value22222");
		Object obj= redisService.get("first-test");
		System.out.println("打印缓存的数据:"+obj);
	}
}
