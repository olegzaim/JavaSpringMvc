package com.em;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.em.repository")
@EntityScan(basePackages = "com.em.model")
public class EmApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(EmApplication.class, args);
	}

}

