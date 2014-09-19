package Phillip.Krall.SMSMailer.exception;

/** Exception to show the user has entered 
 * a wrong SMTP Port
 * @author Phillip Krall
 * @version 1.0.0 Build Sept 19, 2014
 *
 */
public class InvalidGMailPort extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidGMailPort() {
		// TODO Auto-generated constructor stub
	}

	public InvalidGMailPort(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidGMailPort(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidGMailPort(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidGMailPort(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
