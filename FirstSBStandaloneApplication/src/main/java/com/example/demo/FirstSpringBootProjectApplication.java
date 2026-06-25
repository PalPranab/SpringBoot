package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringBootProjectApplication {

	public static void main(String[] args) {

		System.out.println("Application Started...!");

		SpringApplication.run(FirstSpringBootProjectApplication.class, args);

		System.out.println("Application Ended...!");
	}

}
