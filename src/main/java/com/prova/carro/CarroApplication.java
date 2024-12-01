package com.prova.carro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.prova")
@EntityScan(basePackages ={"com.prova.carro.domains","com.prova.carro.domains.enums"})
@EnableJpaRepositories(basePackages = "com.prova.carro.repositories")
@SpringBootApplication
public class CarroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarroApplication.class, args);
	}

}
