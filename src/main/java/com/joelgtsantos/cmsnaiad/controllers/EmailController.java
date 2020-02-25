/**
 * 
 */
package com.joelgtsantos.cmsnaiad.controllers;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import com.joelgtsantos.cmsnaiad.domain.Email;
import com.joelgtsantos.cmsnaiad.services.EmailService;


/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
@Controller
public class EmailController {

	private Logger log = LoggerFactory.getLogger(EmailController.class);
	private static int sentEmails = 0;

	@Autowired
	private EmailService emailService;

	/* (non-Javadoc)
	 * @see com.joelgtsantos.cmsnaiad.controllers.EmailController#receiveMessage(com.joelgtsantos.cmsnaiad.domain.Email)
	 */
	@RabbitHandler
	@RabbitListener(queues = "cmsServiceQueue")
	public void receiveMessage(@Payload Email email) throws InterruptedException {
		this.emailService.sendSimpleMessage(email);
		sentEmails++;
		
		if (sentEmails > 500) {
			log.debug("Emails limit");
			this.doWait();
		}
	}
	
	private void doWait() throws InterruptedException {
		TimeUnit.DAYS.sleep(1);
    }
}
