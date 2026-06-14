package com.lbb.corebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories(basePackages = "com.lbb.corebanking.repository")
@EntityScan(basePackages = "com.lbb.corebanking.domain.entity")
public class CorebankingApplication {
	public static void main(String[] args) {
		SpringApplication.run(CorebankingApplication.class, args);
		System.out.println("********** Core banking Service Start ************");
	}

}
