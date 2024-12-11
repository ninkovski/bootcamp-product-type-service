package com.nttdata.bootcamp_product_type_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.nttdata.bootcamp_product_type_service.repository")

public class BootcampProductTypeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampProductTypeServiceApplication.class, args);
	}

}
