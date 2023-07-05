package com.mengzhou44.firstweb;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("mengzhou44");
		boolean isValidPassword = password.equalsIgnoreCase("password123");
		
		return isValidUserName && isValidPassword;
	}
}
