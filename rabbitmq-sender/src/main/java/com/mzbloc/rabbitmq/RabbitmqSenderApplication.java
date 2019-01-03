package com.mzbloc.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqSenderApplication.class, args);
		try {
			System.in.read();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

