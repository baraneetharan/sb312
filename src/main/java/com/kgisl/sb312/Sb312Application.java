package com.kgisl.sb312;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class Sb312Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb312Application.class, args);
	}

}
