package com.rahul.phmc.util.email.session;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.rahul.phmc.util.email.protocol.SPE_Protocol;

/**
 * @author rahul Makvana
 *
 */
public class SPE_EmailSession {
	
	private int port = 587;
	private String host = "send.one.com";
	private String from = "billing@payhind.com";
	private boolean auth = true;
	private String username = "billing@payhind.com";
	private String password = "Srishti!23";
	private SPE_Protocol protocol = SPE_Protocol.TLS;
	private boolean debug = true;

	public void sendEmail(String to, String subject, String body, String attachFilePath) {

		// Create a Properties object to contain settings for the SMTP protocol
		// provider. You can view a list of possible properties and their
		// descriptions from the com.sun.mail.smtp package here
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		switch (protocol) {
		case SMTPS:
			props.put("mail.smtp.ssl.enable", true);
			break;
		case TLS:
			props.put("mail.smtp.starttls.enable", true);
			break;
		default:
			break;
		}
		// if SMTP authentication is required you must set the mail.smtp.auth
		// property and construct a Authenticator instance that returns a
		// PasswordAuthentication instance with your username and password.

		Authenticator authenticator = null;
		if (auth) {
			props.put("mail.smtp.auth", true);
			authenticator = new Authenticator() {
				private PasswordAuthentication pa = new PasswordAuthentication(username, password);

				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return pa;
				}
			};
		}else{
			props.put("mail.smtp.auth", false);
		}

		// Create a Session instance using the Properties object and the
		// Authenticator object. If SMTP authentication in not needed a null
		// value can be supplied for the Authenticator.
		Session session = Session.getInstance(props, authenticator);
		session.setDebug(debug);

		// Construct a MimeMessage instance, populate the message headers and
		// content and then send the message.
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			message.setRecipients(Message.RecipientType.TO, address);
			message.setSubject(subject);
			message.setSentDate(new Date());
			
			// Instantiate a Multipart object
			MimeMultipart mp = new MimeMultipart();

			
			// create the first bodypart object
			
			if(body !=  null) {
			MimeBodyPart enailbody = new MimeBodyPart(); 
			// create textual content // and add it to the bodypart object 
			enailbody.setContent(body,"text/html"); 
			mp.addBodyPart(enailbody);
			}
			// adds attachments
			if(attachFilePath != null){
			 MimeBodyPart attachPart = new MimeBodyPart();
			 attachPart.attachFile(attachFilePath);
			 mp.addBodyPart(attachPart);
			}
			message.setContent(mp);
			message.saveChanges();
			
			Transport.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
