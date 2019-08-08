package com.spring;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
