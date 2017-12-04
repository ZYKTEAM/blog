package com.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *@author zyk
 */
@SpringBootApplication
public class MyblogApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}
}
