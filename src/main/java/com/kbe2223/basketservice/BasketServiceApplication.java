package com.kbe2223.basketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.kbe2223.basketservice")
@EnableJpaRepositories(basePackages = "com.kbe2223.basketservice.service")
public class BasketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketServiceApplication.class, args);
	}

}
