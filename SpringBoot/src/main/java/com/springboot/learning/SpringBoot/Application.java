package com.springboot.learning.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.learning.SpringBoot")
@EntityScan(basePackages = "com.springboot.learning.SpringBoot.models")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
