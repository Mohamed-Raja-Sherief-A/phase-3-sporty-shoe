package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DAO.UserDAO;
import com.demo.model.UserCredentials;


@Controller
public class RegistrationController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/RegistrationShowForm")
	public String showForm(Model model)
	{
		model.addAttribute("user", new UserCredentials());
		 return "registration";
	}
	
	@RequestMapping("/RegistrationAdd")
	public String addUser(@Valid @ModelAttribute("user") UserCredentials user,BindingResult bindingResult,HttpServletRequest request)
	{
		if(bindingResult.hasErrors())
		{
			return "registration";
		}
		request.setAttribute("message", "User Added Succesfully");
		try
		{
	    userDAO.addUser(user);
		}
		catch(Exception e)
		{
	
			request.setAttribute("message", "User Already Exist");
			return "registration";
		}
		return "registration";
		
	}
	
	@RequestMapping("/Registrationback")
	public String back(Model model)
	{
	model.addAttribute("user", new UserCredentials());
	 return "index";
    }

}
