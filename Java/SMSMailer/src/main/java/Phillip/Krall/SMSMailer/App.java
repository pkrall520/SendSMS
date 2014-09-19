package Phillip.Krall.SMSMailer;

import javax.mail.internet.AddressException;

import Phillip.Krall.SMSMailer.exception.InvalidGMailPort;
import Phillip.Krall.SMSMailer.exception.MessageNotOkay;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			GMailSMSMailer smsMailer = new GMailSMSMailer(GMailSMSMailer.TLS);
			
			// Send To Multiple Users
			smsMailer.setTo("", Sender.VERIZON);
			smsMailer.setTo("", Sender.SPRINT);
			
			// Message To Send
			smsMailer.setMessage("Hello");
			
			smsMailer.setUsername(""); // GMail Username
			smsMailer.setPassword(""); // GMail Password
			smsMailer.send(); // Send Message
			
		} catch (InvalidGMailPort e) {
			e.printStackTrace();
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessageNotOkay e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
