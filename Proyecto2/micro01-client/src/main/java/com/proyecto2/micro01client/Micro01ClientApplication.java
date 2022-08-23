package com.proyecto2.micro01client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Micro01ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Micro01ClientApplication.class, args);
	}

}
