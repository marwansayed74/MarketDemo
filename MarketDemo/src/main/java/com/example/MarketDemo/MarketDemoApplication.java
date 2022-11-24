package com.example.MarketDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MarketDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketDemoApplication.class, args);
	}

}
