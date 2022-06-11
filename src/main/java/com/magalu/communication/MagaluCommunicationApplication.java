package com.magalu.communication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MagaluCommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagaluCommunicationApplication.class, args);
	}

}
