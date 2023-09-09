package com.movie;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;

//import brave.sampler.Sampler;

@EnableEurekaClient
@SpringBootApplication
public class MovieMovieappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieMovieappApplication.class, args);
	}
	
	//@Bean
	//public Sampler alwaysSampler() {
	
	//    return Sampler.ALWAYS_SAMPLE;
	//}

}
