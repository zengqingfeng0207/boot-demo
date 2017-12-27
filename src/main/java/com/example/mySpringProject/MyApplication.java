package com.example.mySpringProject;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class MyApplication {
	
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		InputStream is=MyApplication.class.getClassLoader().getResourceAsStream("my-boot-applicatoin.properties");
		properties.load(is);
		SpringApplication app = new SpringApplication(MyApplication.class);
		app.setDefaultProperties(properties);
		app.run(args);
	}
	
}
