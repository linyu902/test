package com.atguigu.scw.ui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppUiConfig implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/login.html").setViewName("user/login");
		/*registry.addViewController("/index").setViewName("index");
		registry.addViewController("/index.html").setViewName("index");
		*/
	
	}

}
