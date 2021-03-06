package Phillip.Krall.SMSMailer;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import Phillip.Krall.SMSMailer.exception.MessageNotOkay;

/**
 * Abstract SMSMailer used for basic setup
 * of SMS mailing.
 * @author Phillip Krall
 * @version 1.0.0 Build Sept 19, 2014
 *
 */
public abstract class SMSMailer {

	private String SMTP_host = null;
	private int SMTP_port = -1;

	private InternetAddress from = null;
	private List<InternetAddress> to = new ArrayList<InternetAddress>();
	private String message =  null;
	private List<String> attachment = new ArrayList<String>();	

	abstract public void send() throws MessageNotOkay;
	abstract public boolean OKToSend();
	
	protected String getSMTP_host() {
		return SMTP_host;
	}

	protected void setSMTP_host(String sMTP_host) {
		SMTP_host = sMTP_host;
	}

	protected int getSMTP_port() {
		return SMTP_port;
	}

	protected void setSMTP_port(int sMTP_port) {
		SMTP_port = sMTP_port;
	}

	public InternetAddress getFrom() {
		return from;
	}

	public void setFrom(String from) throws AddressException {
		this.from = new InternetAddress(from);
	}

	public List<InternetAddress> getTo() {
		return to;
	}

	public void setTo(String to, Sender sender) throws AddressException {
		this.to.add( new InternetAddress(to + sender.getEmail()));
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment.add(attachment);
	}

}
