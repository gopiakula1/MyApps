// LoginController.java
package com.Boot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register"; // Updated to return "register"
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, RedirectAttributes attr) {
		String res = userService.resgisterUser(user);
		if (res.equals("Register Successfull")) {
			return "redirect:/register_success";
		} else if (res.equalsIgnoreCase("Email already registered")) {
			return "redirect:/register_failed";
		}else if(res.equalsIgnoreCase("Username already exists")) {
			return "redirect:/register_failed";
		}
		else {

			attr.addFlashAttribute("result", res);
			return "redirect:/login";
		}

	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/register_success")
	public String showRegisterSuccesse() {
		return "register_success";
	}
	
	@GetMapping("/register_failed")
	public String showRegisterSuccess() {
		return "register_failed";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes attr) {
		String res = userService.login(username, password);
		System.out.println(username + "" + password);

		attr.addFlashAttribute("res", res);
		System.out.println(res);
		return "redirect:/login";
	}

	@GetMapping("/forgot-password")
	public String showForgotPasswordPage() {

		return "forgot-password";
	}

	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String email, RedirectAttributes attr) {
		String res = userService.forgotPassword(email);
		if (res.equals("Invalid mail")) {
			attr.addFlashAttribute("msg", res);
			return "forgetpassword3";
		}
		return "forgot-password2";

	}

	@GetMapping("/resetPassword")
	public String resetpassword() {
		return "reset_password";
	}

	@PostMapping("/reset-password123")
	public String findByMail(@RequestParam String email, @RequestParam String password, Map<Object, Object> map) {
		String res = userService.findByEmailAndUpdate(email, password);

		if (res.equals("success")) {
			map.put("result", "");
			return "password_created";
		} else {
			map.put("result1", "Password creation failed. Please try again.");
			return "invalid_email";
		}

	}

}
