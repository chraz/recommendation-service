package com.example.recommendationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecommendationServiceApplication {

	private static Logger logger = LoggerFactory.getLogger(RecommendationServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecommendationServiceApplication.class, args);

		logger.info("Application started");
	}

}
