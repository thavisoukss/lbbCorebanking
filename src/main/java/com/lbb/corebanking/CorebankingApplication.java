package com.lbb.corebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorebankingApplication {
	public static void main(String[] args) {
		SpringApplication.run(CorebankingApplication.class, args);
		System.out.println("********** Core banking Service Start ************");
	}

}
