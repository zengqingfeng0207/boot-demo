package com.example.mySpringProject; 
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;
  
@RestController
@EnableAutoConfiguration
@SpringBootApplication  
public class TomcatApplication extends SpringBootServletInitializer{  
   
    
    @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    // 注意这里要指向原先用main方法执行的Application启动类
	    return builder.sources(MyApplication.class);
	  }
}  