package com.springboot.redis.service;

import org.springframework.data.repository.CrudRepository;

import com.springboot.redis.entity.DemoInfo;

/**
 * 使用Spring Data JPA实现
 * DemoInfo 持久化类
 * @author 77596
 *
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {

}
