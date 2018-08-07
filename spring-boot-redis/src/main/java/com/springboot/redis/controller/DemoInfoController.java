package com.springboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.redis.entity.DemoInfo;
import com.springboot.redis.service.DemoInfoService;

@Controller
public class DemoInfoController {

	@Autowired
	DemoInfoService demoInfoService;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		DemoInfo loaded=demoInfoService.findById(1);
		System.out.println("loaded="+loaded);
		DemoInfo cached=demoInfoService.findById(1);
		System.out.println("cached="+cached);
		loaded=demoInfoService.findById(2);
		System.out.println("loaded2="+loaded);
		return "ok";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		demoInfoService.deleteFromCache(id);
		return "ok";
	}
	
	@RequestMapping("/test1")
	@ResponseBody
	public String test1() {
		demoInfoService.test();
		System.out.println("DemoInfoController.test1()");
		return "ok";
	}
}
