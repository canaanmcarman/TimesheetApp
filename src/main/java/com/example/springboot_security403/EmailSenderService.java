package com.example.springboot_security403;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendSimpleEmail(String text,
                                String subject,
                                String email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("camaru9994@gmail.com");
        message.setTo(email);
        message.setText(text);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("mail Send...");

    }
}
