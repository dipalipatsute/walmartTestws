package com.walmart.testws;

public class BaseService {

		protected boolean validRequest(String authToken){
			boolean valid = false;
			boolean notValid = true;
			if(SecurityService.authToken.equals(authToken)){
				return valid;
			}
			return notValid;
		}
}
