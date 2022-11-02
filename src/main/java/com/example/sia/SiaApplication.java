package com.example.sia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.sia.service","com.example.sia.repository"})
public class SiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiaApplication.class, args);
	}

}
