package com.achille.spring.mail;

import javax.mail.MessagingException;

/**
 * @author Achille
 *
 */
public interface MailSender {

	public abstract void send(String to, String subject, String body) throws MessagingException;

}