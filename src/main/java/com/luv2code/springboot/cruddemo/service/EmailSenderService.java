package com.luv2code.springboot.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEMail(String receiverEmail,String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("avjeetyadav00@gmail.com");
        message.setTo(receiverEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        System.out.println("mail send");
    }
}
