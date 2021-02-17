package com.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DAO.ProductDAO;
import com.demo.DAO.UserDAO;
import com.demo.model.Product;
import com.demo.model.UserCredentials;


@Controller
public class LoginController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/LoginCheck")
	public String loginCheck(@Valid @ModelAttribute("user")UserCredentials user,BindingResult bindingResult,HttpServletRequest request)
	{
		if(bindingResult.hasErrors())
		{
			return "index";
		}
		
		UserCredentials us=userDAO.credentialsCheck(user);
		if(us!=null)
		{	  ArrayList<Product> cart=new ArrayList<Product>();
			HttpSession session=request.getSession();
			session.setAttribute("userid", us.getUid());
			session.setAttribute("username", us.getUsername());
			  session.setAttribute("cart", cart);
			if(user.getUsername().equals("Admin"))
			{
			return "mainmenu";
			}
			else
			{ 
			  request.setAttribute("products", productDAO.getProducts());
			  return "eshop";
			}
		}
		else
		{
			request.setAttribute("message", "invalid credentails");
			return "index";
		}
	}
	
}
