/**
 * 
 */
package com.joelgtsantos.cmsnaiad.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.joelgtsantos.cmsnaiad.controllers.EmailController;
import com.joelgtsantos.cmsnaiad.domain.Email;
import com.joelgtsantos.cmsnaiad.services.EmailService;

/**
 * @author Joel Santos
 *
 * cms-naiad
 * 2018
 */
public class EmailControllerTest {

	@Mock
	EmailService emailService;

    @InjectMocks
	EmailController emailController;
	
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //emailService = new EmailServiceImpl(emailSender);
    }


	@Test
	public void sendSimpleMessage() throws Exception {
		//Given
		Email email = new Email("cmsinfo@gmail.com", "cmsinfo2@gmail.com", "text", "register");
		
		//When
		emailController.receiveMessage(email);
		
        //Then
        verify(emailService, times(1)).sendSimpleMessage(any(Email.class));
	}

}
