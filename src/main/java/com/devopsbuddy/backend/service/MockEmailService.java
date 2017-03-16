package com.devopsbuddy.backend.service;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.devopsbuddy.web.domain.frontend.FeedbackPojo;

public class MockEmailService extends AbstractEmailService{


	@Override
	public void sendGenericEmailMessage(SimpleMailMessage message) {
		
		
	}

}
