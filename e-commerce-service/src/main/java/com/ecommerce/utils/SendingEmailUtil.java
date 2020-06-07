package com.ecommerce.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SendingEmailUtil {
	
	
	
	public String sendMail(String emailOfUser) {
		// Setting up configurations for the email connection to the Google SMTP server
		// using TLS
		int otp = 0;
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		// Establishing a session with required user details
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ecommercesite29@gmail.com", "London@12345");
			}
		});
		try {
			// Creating a Message object to set the email content
			MimeMessage msg = new MimeMessage(session);
			// Storing the comma seperated values to email addresses
			String to = emailOfUser;
			/*
			 * Parsing the String with defualt delimiter as a comma by marking the boolean
			 * as true and storing the email addresses in an array of InternetAddress
			 * objects
			 */
			otp = generateOTP();
			InternetAddress[] address = InternetAddress.parse(to, true);
			// Setting the recipients from the address variable
			msg.setRecipients(Message.RecipientType.TO, address);
			String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
			msg.setSubject("One Time Password");
			msg.setSentDate(new Date());
			msg.setText("Hi User, /n Your OTP is "+otp+ "./n Thanks,/nEcommerce Development Team");
			msg.setHeader("XPriority", "1");
			Transport.send(msg);
			System.out.println("Mail has been sent successfully");
		} catch (MessagingException mex) {
			System.out.println("Unable to send an email" + mex);
		}

		return String.valueOf(otp);
	}

	private int generateOTP() {
		int a = (int) (Math.random() * 10000);
		return a;

	}

}
