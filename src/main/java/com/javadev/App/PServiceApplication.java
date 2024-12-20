package com.javadev.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableMongoRepositories(basePackages = "com.javadev.repository")
@ComponentScan(basePackages = {"com.javadev.controller","com.javadev.dto","com.javadev.service","com.javadev.model"})
public class PServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PServiceApplication.class, args);
	}

}
