package com.example.userServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServicesApplication.class, args);
	}
	
	
	//configure RestTemplate class as Spring bean so that we can inject and use it.
	  @Bean
	    public RestTemplate restTemplate(){
	        return new RestTemplate();
	    }

}
