package com.example.hikes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class HikesApplication {
	public static void main(String[] args) {

		SpringApplication.run(HikesApplication.class, args);

	}
}
