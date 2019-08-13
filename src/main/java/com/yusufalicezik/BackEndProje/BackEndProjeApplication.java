package com.yusufalicezik.BackEndProje;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackEndProjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndProjeApplication.class, args);

	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
