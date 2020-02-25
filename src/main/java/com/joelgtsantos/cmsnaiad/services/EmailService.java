/**
 * 
 */
package com.joelgtsantos.cmsnaiad.services;

import com.joelgtsantos.cmsnaiad.domain.Email;

/**
 * @author Joel Santos
 *
 * cms-naiad
 * 2018
 */
public interface EmailService {
	void sendSimpleMessage(Email email);
}
