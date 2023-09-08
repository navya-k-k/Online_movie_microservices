package com.movie;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MoiveEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoiveEurekaServerApplication.class, args);
	}

}
