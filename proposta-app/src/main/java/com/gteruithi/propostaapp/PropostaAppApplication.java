package com.gteruithi.propostaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@EnableScheduling
@SpringBootApplication
@EnableWebSocketMessageBroker
public class PropostaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropostaAppApplication.class, args);
	}

}
