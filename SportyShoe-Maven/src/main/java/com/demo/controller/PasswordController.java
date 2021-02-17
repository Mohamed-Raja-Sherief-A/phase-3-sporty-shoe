package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class PasswordController {
	
	//AutoWires the Repository
	@Autowired
	private UserDAO userDAO;

	//Shows the password change form
	@RequestMapping("/PasswordChangeForm")
	public String showPasswordChangeForm(Model model)
	{
		model.addAttribute("user", new UserCredentials());
		return "passwordForm";
	}
	
	//Change password action
	@RequestMapping("/ChangePassword")
	public String changePassword(@Valid @ModelAttribute("user") UserCredentials user,BindingResult bindingResult,HttpServletRequest request)
	{
		
		 try
		 {
			System.out.println("inside");
			HttpSession session=request.getSession();
			int id=(int)session.getAttribute("userid");
			userDAO.ChangePassword(user.getPassword().trim(),id);//Method call for setting new password
			request.setAttribute("message", "password changed");
			return "passwordForm";
		 }
		 catch(Exception e)
		 {
			 request.setAttribute("message", "Enter valid value");
			 return "passwordForm";
		 }
			
	 }

		
		
	}

