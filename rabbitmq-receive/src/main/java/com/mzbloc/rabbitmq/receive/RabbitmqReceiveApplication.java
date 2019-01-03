package com.mzbloc.rabbitmq.receive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqReceiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqReceiveApplication.class, args);
		try{
			System.in.read();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

}

