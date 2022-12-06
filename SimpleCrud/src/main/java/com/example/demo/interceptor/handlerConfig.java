package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class handlerConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private StudentInterceptor student;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(student);
	}
	
	

}
