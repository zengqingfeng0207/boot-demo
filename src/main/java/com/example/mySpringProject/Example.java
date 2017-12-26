package com.example.mySpringProject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
@EnableAutoConfiguration
@RequestMapping("myExample")
public class Example {

	@RequestMapping("/")
	public String home(){
		return "Hello World";
	}
	
	
	@RequestMapping("/hello/{myName}")
	public String index(@PathVariable String myName){
		return "Hello "+myName+"!";
	}
}
