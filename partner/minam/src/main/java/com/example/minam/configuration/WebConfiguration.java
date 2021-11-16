package com.example.minam.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	//CORS ¼³Á¤
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedOrigins(
					"http://localhost:3000",
					"http:ec2-3-36-125-183.ap-northeast-2.compute.amazonaws.com")
			.allowedMethods("*");
	}
}
