package com.spring;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebContainerApplication {
	public static void main(String[] args) {
		String resource = "MybatisXml/db.properties";
		Properties properties = new Properties();
		try {
			Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
            System.out.println(properties.getProperty("db.driver"));
            System.out.println(properties.getProperty("db.username"));
            System.out.println(properties.getProperty("db.password"));
            System.out.println(properties.getProperty("db.url"));
		}catch (IOException e) {
            e.printStackTrace();
        }
		//SpringApplication.run(WebContainerApplication.class, args);
	}
}
