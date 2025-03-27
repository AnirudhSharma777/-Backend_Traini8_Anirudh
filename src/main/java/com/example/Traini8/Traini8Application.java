package com.example.Traini8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Traini8Application {

	public static void main(String[] args) {
		SpringApplication.run(Traini8Application.class, args);
	}

}
