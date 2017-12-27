package com.example.mySpringProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mySpringProject.bean.UserInfo;

@RestController
@RequestMapping("user")
@EnableAutoConfiguration
public class UserController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("/showUserInfo")
	public List<Map<String, Object>> showUserInfo(){
		String sql = "select * from S61.T6110";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		 
		 return list;
	}
	
	
	@RequestMapping("/showUserInfo/{name}")
	public UserInfo showUserInfo(@PathVariable String name){
		String sql = "select F01 AS id,F02  AS name from S61.T6110 WHERE F02=?";
		
		 List<UserInfo> list = jdbcTemplate.query(sql, new Object[]{name},new BeanPropertyRowMapper<UserInfo>( UserInfo.class));
		 UserInfo userInfo=null;
		 if(list!=null && list.size()>0){
			 userInfo = list.get(0);
		 }
		 
		return userInfo;
	}

	@RequestMapping("/userIndex/{id}")
	public ModelAndView userIndex(@PathVariable Integer id){
		
		 String sql = "select F01 AS id,F02  AS name from S61.T6110 WHERE F01=?";
		
		 List<UserInfo> list = jdbcTemplate.query(sql, new Object[]{id},new BeanPropertyRowMapper<UserInfo>( UserInfo.class));
		 UserInfo userInfo=null;
		 if(list!=null && list.size()>0){
			 userInfo = list.get(0);
		 }
		 
		return new ModelAndView("/index.jsp").addObject("userInfo",userInfo);
	}
}
