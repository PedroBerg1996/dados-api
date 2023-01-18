package com.dados;








import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;






@SpringBootApplication
public class DadosApiApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(DadosApiApplication.class, args);
		
		
		
		
	}
	
	
	 

}
