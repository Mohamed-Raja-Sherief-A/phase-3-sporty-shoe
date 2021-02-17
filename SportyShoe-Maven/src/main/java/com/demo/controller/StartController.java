package com.demo.controller;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.model.UserCredentials;

@Controller
public class StartController {

	@RequestMapping("/")
	public String showForm(Model model)
	{
		model.addAttribute("user", new UserCredentials());
		System.out.println("inside start controller");
		return "index";
	}
}
