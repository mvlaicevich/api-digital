package com.digital.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan("com.digital.springbootapi.model")
@EnableWebMvc
public class SpringbootapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

}
