package com.springboot.redis.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.springboot.redis.entity.DemoInfo;
import com.springboot.redis.service.DemoInfoRepository;
import com.springboot.redis.service.DemoInfoService;

/**
 * DemoInfo数据处理类
 * 编写DemoInfoService，这里有两个技术方面，
 * 第一就是使用Spring @Cacheable注解方式和RedisTemplate对象进行操作
 * @author 77596
 *
 */
@Service
public class DemoInfoServiceImpl implements DemoInfoService {

	@Resource
	private DemoInfoRepository demoInfoRepository;
	
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * @Cacheable 支持如下几个参数：

	 * value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name

     * key：缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL

     * condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL
	 */
	
	@Cacheable(value="demoInfo")//缓存，这里没有指定key
	@Override
	public DemoInfo findById(long id) {
		System.err.println("DemoInfoService.findById()======从数据库中进行获取的....id="+id);
		return demoInfoRepository.findOne(id);
	}

	/**
	 * @CacheEvict 支持如下几个参数：

	 * value：缓存位置名称，不能为空，同上

 	 * key：缓存的key，默认为空，同上

     * condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL

     * allEntries：true表示清除value中的全部缓存，默认为false
	 */
	@CacheEvict(value="demoInfo")
	@Override
	public void deleteFromCache(long id) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除");
	}

	@Override
	public void test() {
		ValueOperations<String, String> valueOpertations=redisTemplate.opsForValue();
		valueOpertations.set("mykey4", "radom1="+Math.random());
		System.out.println(valueOpertations.get("mykey4"));
	}

}
