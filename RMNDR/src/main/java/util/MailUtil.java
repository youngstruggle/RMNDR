package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Nana Febriana
 */

public class MailUtil {
	public static void main(String[] args) {
	}

	public String sendMailForReminderAuth(String emailFrom, String emailRecipent, String subject, String content) {
		String strReturn = "";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					/* To do: Isi email dan password dari settingan atau parameter */
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("xxxxxx@inspirotechs.com",
								"xxxx");
					}
				});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailFrom));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailRecipent));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);

			strReturn = "success";
			System.out.println("Done");

		} catch (MessagingException e) {
			strReturn = "failed";
			throw new RuntimeException(e);
		}

		return strReturn;
	}
}
