/**
 * 
 */
package com.joelgtsantos.cmsnaiad.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.joelgtsantos.cmsnaiad.domain.Email;
import com.joelgtsantos.cmsnaiad.services.ContentBuilderService;
import com.joelgtsantos.cmsnaiad.services.EmailServiceImpl;

/**
 * @author Joel Santos
 *
 * cms-naiad
 * 2018
 */
public class EmailServiceImplTest {
	
	@Mock
    JavaMailSender emailSender;
	
	@Mock
    ContentBuilderService contentBuilderService;
	
	EmailServiceImpl emailService;
	
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        emailService = new EmailServiceImpl(emailSender, contentBuilderService);
    }


	@Test
	public void sendSimpleMessage() throws Exception {
		//Given
		Email email = new Email("cmsinfo@gmail.com", "cmsinfo2@gmail.com", "text", "register");
		
		//When
        emailService.sendSimpleMessage(email);
		
        //Then
        verify(emailSender, times(1)).send(any(MimeMessagePreparator.class));
	}

}
