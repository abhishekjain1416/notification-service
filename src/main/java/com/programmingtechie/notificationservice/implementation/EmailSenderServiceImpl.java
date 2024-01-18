package com.programmingtechie.notificationservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.programmingtechie.notificationservice.service.EmailSenderService;

@Component
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
    private JavaMailSender mailSender;

    /**
     * This method sends an email using the provided parameters
     * @param toEmail
     * @param subject
     * @param body
     */
	@Override
    public void sendEmail(String toEmail, String subject, String body)
    {
        // Create a SimpleMailMessage object to hold the email details
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("abhishekjain1416@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        // Use the JavaMailSender to send the email message
        mailSender.send(message);

        System.out.println("Mail Sent Successfully");
    }
}
