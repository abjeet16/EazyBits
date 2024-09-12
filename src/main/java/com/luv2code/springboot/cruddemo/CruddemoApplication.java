package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CruddemoApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	/*
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		emailSenderService.sendEMail("abjeetyadav00@gmail.com",
				"hi bro",
				"just saying hi");
	}*/

}
