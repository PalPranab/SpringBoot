package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bean.Student;

@Configuration
public class AppConfig {

	@Bean
	public CommandLineRunner cmdLineRunner() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				stdBean1().displayStdDetails();
				
				System.out.println("---------------");
				stdBean2().displayStdDetails();
				
			}
		
		};
	}

	@Bean
	public Student stdBean1() {

		return new Student("Pranab", 65, 95.2f);

	}

	@Bean
	public Student stdBean2() {

		return new Student("Babai", 75, 90.2f);

	}
}
