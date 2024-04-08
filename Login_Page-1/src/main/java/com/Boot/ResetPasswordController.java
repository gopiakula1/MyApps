package com.Boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResetPasswordController {

    @Autowired
    private UserService userService;

    @GetMapping("/forgotPassword")
    public String showResetPasswordPage() {
        // Check token validity and show reset password page
    	
        return "forgot";
    }
    
    
	/* @PostMapping("/forgot-password")
	public String sendingMail(@RequestParam String email) {
	String res=	userService.forgotPassword(email);
		return res;
	}*/

	/* @PostMapping("/reset")
	public String resetPassword(@RequestParam String token, @RequestParam String newPassword) {
	    userService.resetPassword(token, newPassword);
	    return "redirect:/login";
	}*/
}