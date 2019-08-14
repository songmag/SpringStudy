package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:MybatisXml/configuration_mybatis.xml")
public class WebContainerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebContainerApplication.class, args);
	}
}
