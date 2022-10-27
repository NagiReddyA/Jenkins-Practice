package com.nagi.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication 
public class SpringMysqlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

}
		