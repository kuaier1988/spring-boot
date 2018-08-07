package com.springboot.redis4.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.redis4.entity.User;

@RestController
public class TestController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/testString")
	public void testString() throws Exception{
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Object obj=stringRedisTemplate.opsForValue().get("aaa");
		System.out.println(obj);
	}
	
	@RequestMapping("/testObj")
	public void testObj() throws Exception{
		User user=new User("aa@126.com", "aa", "aa123456", "aa", "123");
		ValueOperations<String, User> operations=redisTemplate.opsForValue();
		operations.set("com.neox", user);
		operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		boolean exists=redisTemplate.hasKey("com.neo.f");
		if(exists) {
			System.out.println("exists is true");
		}else {
			System.out.println("exists is false");
		}
		
		System.out.println("===获取缓存中的值===");
		System.out.println(operations.get("com.neox"));
	}

}
