package com.aek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import feign.Request;

@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@EnableScheduling
public class AekDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AekDataApplication.class, args);
	}

	@Bean
	Request.Options feignOptions() {
		return new Request.Options(
				100 * 1000, 
				100 * 1000);
	}
}
