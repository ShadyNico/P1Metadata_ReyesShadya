package com.example.Proyecto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Indica que esta es la aplicación principal
// de Spring Boot.
@SpringBootApplication
public class Proyecto1Application {

	public static void main(String[] args) {

		// Inicia toda la aplicación Spring Boot.
		SpringApplication.run(
				Proyecto1Application.class,
				args
		);
	}
}