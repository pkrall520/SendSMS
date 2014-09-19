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
			GMailSMSMailer smsMailer = new GMailSMSMailer(GMailSMSMailer.SSL);
			
			smsMailer.setTo("", Sender.VERIZON);
			smsMailer.setFrom("");
			smsMailer.setMessage("Hello");
			smsMailer.setUsername("");
			smsMailer.setPassword("");
			smsMailer.send();
			
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
