package com.luv2code.springdemo.controller;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.luv2code.springdemo")
public class WebApplicationStarter extends SpringBootServletInitializer {



	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(WebApplicationStarter.class, args);
	}


}


