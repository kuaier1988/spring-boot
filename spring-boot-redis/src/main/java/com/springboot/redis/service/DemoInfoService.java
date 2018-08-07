package com.springboot.redis.service;

import com.springboot.redis.entity.DemoInfo;

public interface DemoInfoService {
	public DemoInfo findById(long id);
	
	public void deleteFromCache(long id);
	
	void test();

}
