package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyControllers {

	@Autowired
	private UserService userService;

	@GetMapping("/regPage")
	public String openRegistrationPage(Model model) {

		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {

		boolean status = userService.rgisterUser(user);
		if (status) {
			model.addAttribute("successMsg", "User register successfully.");
		} else {
			model.addAttribute("errorMsg", "User not register due to some error.");
		}
		return "register";
	}

	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {

		model.addAttribute("user", new User());

		return "login";
	}

	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {

		User validUser = userService.loginUser(user.getEmail(), user.getPassword());

		if (validUser != null) {

			model.addAttribute("userName", validUser.getName());
			return "profile";

		} else {

			model.addAttribute("errorMsg", "Email id or password didn't match.");
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);

		if (session != null) {

			session.invalidate();
		}
//		model.addAttribute("user", new User());
//		return "login";
		return "redirect:/loginPage";

	}
}
