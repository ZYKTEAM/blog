package com.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.myblog.common.config.CommonPropertyConfiguration;

/**
 *@author zyk
 */
@SpringBootApplication
@EnableConfigurationProperties(CommonPropertyConfiguration.class)
public class MyblogApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyblogApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}
}
