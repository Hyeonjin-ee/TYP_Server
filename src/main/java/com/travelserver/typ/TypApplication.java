package com.travelserver.typ;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableBatchProcessing
public class TypApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypApplication.class, args);
	}

}
