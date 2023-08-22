package com.microservices.movie;

import com.microservices.movie.event.RentalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@KafkaListener(topics = "rentalSaveTopic")
	public void handleRentalNotification(RentalEvent rentalEvent){
		log.info("New Movie Rented!!!! {}", rentalEvent.getRentalId());
	}
}
