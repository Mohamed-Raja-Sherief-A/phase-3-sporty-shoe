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
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/PasswordChangeForm")
	public String showPasswordChangeForm(Model model)
	{
		model.addAttribute("user", new UserCredentials());
		return "passwordForm";
	}
	
	@RequestMapping("/ChangePassword")
	public String changePassword(@Valid @ModelAttribute("user") UserCredentials user,BindingResult bindingResult,HttpServletRequest request)
	{
		/*if(bindingResult.hasErrors())
		{
			System.out.println("inside error");
			return "passwordForm";
		}
		else
		{*/
			try
			{
			System.out.println("inside");
			HttpSession session=request.getSession();
			int id=(int)session.getAttribute("userid");
			userDAO.ChangePassword(user.getPassword().trim(),id);
			request.setAttribute("message", "password changed");
			return "passwordForm";
			}
			catch (Exception e) {
				// TODO: handle exception
				request.setAttribute("message", "pls enter valid values");
				return "passwordForm";
			}

		}
		
	}

