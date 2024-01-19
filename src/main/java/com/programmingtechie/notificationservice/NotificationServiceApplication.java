package com.programmingtechie.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.programmingtechie.notificationservice.dto.OrderPlacedEvent;
import com.programmingtechie.notificationservice.service.EmailSenderService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	@Autowired
	EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	/**
	 * This method should listen for messages from the "notificationTopic" Kafka topic
	 * @param orderPlacedEvent
	 */
	@KafkaListener(topics = "notificationTopic")
	public void handleNotifications(OrderPlacedEvent orderPlacedEvent) {

		/**
		 * Send out an email notification using the EmailSenderService.
		 * Note: You may need to provide a valid email address in the first parameter.
		 */
		senderService.sendEmail(
			"",
			"Order Placed Successfullly",
			"Your order has been placed successfully with Order ID "+orderPlacedEvent.getOrderNumber()
		);

		// Log the received notification information
		log.info("Received notification for order - {}",orderPlacedEvent.getOrderNumber());
	}
}
