package Phillip.Krall.SMSMailer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Sender {
	
		T_MOBILE ("@tmomail.net"),
		VIRGIN_MOBILE ("@vmobl.com"),
		SPRINT ("@messaging.sprintpcs.com"),
		VERIZON ("@vtext.com");
		
	private String email;
		
	private static final Map<String, Sender> lookup = new HashMap<String, Sender>();
	
	static{
		for(Sender s: EnumSet.allOf(Sender.class))
			lookup.put(s.getEmail(), s);
	}
	
	Sender(String emailAddress){
		email = emailAddress;
	}
	
	public static Sender get(String email){
		return lookup.get(email);
	}

	public String getEmail() {
		return email;
	}
}
