package Phillip.Krall.SMSMailer;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Phillip.Krall.SMSMailer.exception.InvalidGMailPort;
import Phillip.Krall.SMSMailer.exception.MessageNotOkay;

/**
 * Google GMail SMS Mailer. Uses google profile to send SMS 
 * messages to users. The "From" displays as the gmail 
 * account email.
 * @author Phillip Krall
 * @version 1.0.0 Build Sept 19, 2014
 *
 */
public class GMailSMSMailer extends SMSMailer {

	/**
	 * Google's Default TLS Port (587)
	 */
	final static public int TLS = 587;
	/**
	 * Google's Default SSL Port (465)
	 */
	final static public int SSL = 465;
	
	private String username = null;
	private String password = null;
	
	
	{
		super.setSMTP_host("smtp.gmail.com");
		super.setSMTP_port(SSL);
	}
	
	/**
	 * Constructor to initialize SMTP_port  
	 * @param SMTP_port Google SMTP Port
	 * @throws InvalidGMailPort SMTP_port must be a valid Google SMTP Port. Use constant TLS or SSL
	 */
	public GMailSMSMailer(int SMTP_port) throws InvalidGMailPort {
		if( SMTP_port != TLS && SMTP_port != SSL ) {
			throw new InvalidGMailPort("ERROR : Invalid Google Mail SMTP PORT. Use Constant TSL or SSL");			
		}
		super.setSMTP_port(SMTP_port);
	}
	
	/**
	 * Override because GMail sets the From to the GMail User account (Do Not Use)
	 * @param from Not Important
	 */
	@Override
	public void setFrom(String from) {
		System.out.println("GMailSMSMailer does not use the setFrom Mesage. All SMS/ Emails are sent from the GMail Username");
	}

	/**
	 * Send the currently set parameter is a message
	 */
	@Override
	public void send() throws MessageNotOkay {
		if(!OKToSend())
			throw new MessageNotOkay("ERROR : Not All Fields Were Filled Out Correctly");
		
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", super.getSMTP_host());
		props.put("mail.smtp.port", super.getSMTP_port());
		
		if(super.getSMTP_port() == TLS) {
			props.put("mail.smtp.starttls.enable", "true");
		}
		
		else if(super.getSMTP_port() == SSL) {

			props.put("mail.smtp.socketFactory.port", super.getSMTP_port());
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
		}
		
		Session session = Session.getDefaultInstance(props, 
				new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(username, password);
					}
		
				}
		);
		
		try{
			Message message = new MimeMessage(session);
			message.setFrom(super.getFrom());
			
			List<InternetAddress> listAddresses = super.getTo();
			
			InternetAddress[] addresses = new InternetAddress[listAddresses.size()];
			for(int i = 0; i < addresses.length; i++)
				addresses[i] = listAddresses.get(i);
			
			message.setRecipients(Message.RecipientType.TO, addresses);
			message.setText(super.getMessage());
			Transport.send(message);
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Check if all parameters for a message are set
	 * @return Boolean True if message is good to be sent, false if not
	 */
	@Override
	public boolean OKToSend() {
		if( super.getMessage() != null && super.getSMTP_host() !=  null && super.getSMTP_port() != -1 && (super.getSMTP_port() != SSL || super.getSMTP_port() != TLS)  && super.getTo().size() > 0)
			return true;
		return false;
	}
	
	/**
	 * Get the Google Mail Username that is current set
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the Google Mail Username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Set the Google Mail Password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
