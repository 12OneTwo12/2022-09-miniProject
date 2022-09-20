package com.playdata.petCommunity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.playdata.petCommunity.util.interceptor.UserAuthHandler;

@Configuration 
public class WebConfig implements WebMvcConfigurer{
	
	@Bean
	public UserAuthHandler userAuthHandler()	{
		return new UserAuthHandler();
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor( userAuthHandler() )
				.addPathPatterns("/user/**")
				.addPathPatterns("/doctor/**")
				.addPathPatterns("/pet/**")
				.addPathPatterns("/notice/**")
				.addPathPatterns("/comment/**")
				
				.excludePathPatterns("/main")
				.excludePathPatterns("/notice/noticeListAll")
				.excludePathPatterns("/notice/noticeDetail");
	}
	
}
