package com.ucd.ecs235.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ucd.ecs235"})
public class JwtResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtResourceServerApplication.class, args);
	}

}
