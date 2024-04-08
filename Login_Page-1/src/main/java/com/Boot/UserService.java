package com.Boot;

public interface UserService {
	  boolean isEmailRegistered(String email);
    String resgisterUser(User user);
    
    String login(String username,String password);

	String forgotPassword(String email);
    

	String findByEmailAndUpdate(String email,String pword) ;

	
	
}