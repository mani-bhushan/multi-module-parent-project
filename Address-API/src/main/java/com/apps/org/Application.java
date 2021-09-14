package com.apps.org;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*@ComponentScan( basePackages = {
	"com.apps.org.custom.configurations.*", 
	"com.apps.org.controller.*", 
	"com.apps.org.dao.*", 
	"com.apps.org.entity.*", 
	"com.apps.org.model.*",
	"com.apps.org.service.*", 
	"com.apps.org.util.*"
	})*/
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			/*
			 * for (ApplicationElement ae : ApplicationElement.values()) {
			 * System.out.println(ae.toString()); }
			 */
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println("BeanName : " + beanName);
			}

		};
	}

}
