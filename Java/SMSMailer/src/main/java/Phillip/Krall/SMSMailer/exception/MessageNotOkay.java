package Phillip.Krall.SMSMailer.exception;

/** 
 * Exception to show that a message is not valid
 * @author Phillip Krall
 * @version 1.0.0 Build Sept 19, 2014
 *
 */
public class MessageNotOkay extends Exception {

	private static final long serialVersionUID = 1L;

	public MessageNotOkay() {
		// TODO Auto-generated constructor stub
	}

	public MessageNotOkay(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MessageNotOkay(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MessageNotOkay(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MessageNotOkay(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
