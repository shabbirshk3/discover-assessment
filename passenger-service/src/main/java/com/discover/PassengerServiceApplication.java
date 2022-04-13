package com.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;



@EnableJpaRepositories("com.discover.repository")
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication

public class PassengerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
