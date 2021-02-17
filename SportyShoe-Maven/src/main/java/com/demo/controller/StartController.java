package com.demo.controller;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.model.UserCredentials;

@Controller
public class StartController {

	//Initial Page Login Page Transfer
	@RequestMapping("/")
	public String showForm(Model model)
	{
		model.addAttribute("user", new UserCredentials());
		return "index";
	}
}
