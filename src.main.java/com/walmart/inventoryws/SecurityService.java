package com.walmart.inventoryws;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Security")
public class SecurityService {
	public static final String authToken = (new Integer(new Random(19580427).nextInt())).toString();
	
//	URLPattern: /security/authToken
	@GET
	@Path("authToken")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAuthToken(){
		System.out.println("get one");
		return authToken;
	}
}
