package com.savings.scheme_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SchemeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchemeServiceApplication.class, args);
	}
}
