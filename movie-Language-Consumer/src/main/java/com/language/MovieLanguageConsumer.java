package com.language;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;

//import brave.sampler.Sampler;

@EnableFeignClients
@SpringBootApplication
public class MovieLanguageConsumer {

	public static void main(String[] args) {
		SpringApplication.run(MovieLanguageConsumer.class, args);
	}
	
	//@Bean
	//public Sampler alwaysSampler() {
	
	//    return Sampler.ALWAYS_SAMPLE;
	//}

}
