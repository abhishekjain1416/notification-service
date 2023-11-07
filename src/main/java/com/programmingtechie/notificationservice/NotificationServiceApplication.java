package com.programmingtechie.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	@Autowired
	EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotifications(OrderPlacedEvent orderPlacedEvent) {

		// Send out an email notification
		senderService.sendEmail(
			"",
			"Order Placed Successfullly",
			"Your order has been placed successfully with Order ID "+orderPlacedEvent.getOrderNumber()
		);

		log.info("Received notification for order - {}",orderPlacedEvent.getOrderNumber());
	}
}
