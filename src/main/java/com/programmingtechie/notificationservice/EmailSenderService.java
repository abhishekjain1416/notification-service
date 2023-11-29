package com.programmingtechie.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    
    @Autowired
    private JavaMailSender mailSender;

    /**
     * This method sends an email using the provided parameters
     * @param toEmail
     * @param subject
     * @param body
     */
    public void sendEmail(String toEmail, String subject, String body)
    {
        // Create a SimpleMailMessage object to hold the email details
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        // Use the JavaMailSender to send the email message
        mailSender.send(message);

        System.out.println("Mail Sent Successfully");
    }
}
