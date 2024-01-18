package com.programmingtechie.notificationservice.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {

	// This method sends an email using the provided parameters
	void sendEmail(String toEmail, String subject, String body);

}
