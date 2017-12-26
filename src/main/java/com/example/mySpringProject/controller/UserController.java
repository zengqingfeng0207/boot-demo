package com.example.mySpringProject.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mySpringProject.bean.UserInfo;

@RestController
@RequestMapping("user")
@EnableAutoConfiguration
public class UserController {
	
	@RequestMapping("/showUserInfo/{name}")
	public UserInfo showUserInfo(@PathVariable String name){
		UserInfo userinfo  = new UserInfo();
		userinfo.setId(1);
		userinfo.setName(name);
		return userinfo;
	}

	@RequestMapping("/userIndex/{id}")
	public ModelAndView userIndex(@PathVariable Integer id){
		UserInfo userinfo  = new UserInfo();
		userinfo.setId(id);
		userinfo.setName("Frank");
		return new ModelAndView("/index.jsp").addObject("userInfo",userinfo);
	}
}
