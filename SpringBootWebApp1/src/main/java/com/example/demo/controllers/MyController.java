package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@Controller
public class MyController {

	@Autowired
	private UserService userService;

	@GetMapping("/regPage")
	public String openRegPage(Model model) {

		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {
		boolean status = userService.registerUser(user);

		if (status) {
			
			model.addAttribute("successMsg", "User Register successfuly....!");
			
		} else {
			
			model.addAttribute("errorMsg", "User not register due to some error...!");
		}
		return "register";
	}
}
