package com.messaging.client;

import java.io.File;
import java.io.IOException;

import com.syniverse.scgapi.AuthInfo;
import com.syniverse.scgapi.MessageRequest;
import com.syniverse.scgapi.Scg;
import com.syniverse.scgapi.Session;

public class Client {
	public static void main(String args[]) throws Exception{
		/*System.out.println("Phone No. - "+args[0]);
		System.out.println("Message - "+args[1]);
		new Client().sendMessage(args[0], args[1]);*/
		
		new Client().sendMessage("+1XXXXXXXXXX", "This is a test msg");
	}
	
	public String sendMessage(String phoneNumber, String message) throws Exception{

		 // Construct an instance of the authentication object
	    // with authentication data from auth.json
	    AuthInfo auth = new AuthInfo(new File("auth.json"));
	    // Prepare a session to the server.
	    Scg scg = new Scg();
	    Session session = scg.connect("https://api.syniverse.com", auth);

	    // Send SMS message
	    MessageRequest.Resource res = new MessageRequest.Resource(session);
	    MessageRequest mrq = new MessageRequest();
	    mrq.setFrom("channel:" + "1KJPMkuHQkair_o15etpmg");
	    mrq.setTo(phoneNumber);
	    mrq.setBody(message);

	    String reqId = res.create(mrq);

	    System.out.println("Sent message request " + reqId);
	    return reqId;
	}
}
