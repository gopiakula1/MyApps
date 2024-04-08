package com.Boot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

   

	@Override
	public String resgisterUser(User user) {
		
		 if (userRepository.existsByUsername(user.getUsername())) {
	            return "Username already exists";
	        }
		 if (isEmailRegistered(user.getEmail())) {
		        return "Email already registered";
		    }
		
		userRepository.save(user);
	return "Register Successfull";
		
	}

	@Override
	public String login(String username, String password) {
	Optional<User> userOptional=	userRepository.findByUsernameAndPassword(username, password);
	if(userOptional.isPresent()) {
		User u1=userOptional.get();
		return "Login Successfull";
	}
	return "Invalid credentials";
	}

	@Override
	public String forgotPassword(String email) {
		User user = userRepository.findByEmail(email);
		 String message = "Hello,\n\n";
	        message += "You have requested to reset your password. ";
	        message += "Please click on the following link to reset your password: \n";
	        message += "http://localhost:9900/login/resetPassword\n\n";
	        message += "If you did not request a password reset, please ignore this email.\n\n";
	        message += "Best regards,\nYour Application Team";

		if(user!=null) {
		emailService.sendEmail(email, "Reset-Password",message);
		return "An mail sent to ur mail id";
	}
	 return "Invalid mail";
	}

	@Override
	public String findByEmailAndUpdate(String email, String pword) {
		User user=userRepository.findByEmail(email);
		if(user!=null) {
			user.setPassword(pword);
		//	user.setPasswordExpirationTime(LocalDateTime.now().plusSeconds(30));
			userRepository.save(user);
			return "success";
			
		}
		return "invalid credentials";
	}

	@Override
	public boolean isEmailRegistered(String email) {
		return userRepository.findByEmail(email) != null;
	}



	
}