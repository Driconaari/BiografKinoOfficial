package com.example.kinozippy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.kinozippy.entity") // Adjust the package name as necessary
public class KinoZippyApplication {
	public static void main(String[] args) {
		SpringApplication.run(KinoZippyApplication.class, args);
	}
}
