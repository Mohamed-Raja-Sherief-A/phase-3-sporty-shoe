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
	//Repository auto wiring
	@Autowired
	private UserDAO userDAO;
	//Repository auto wiring
	@Autowired
	private ProductDAO productDAO;
	//Maps the login check 
	@RequestMapping("/LoginCheck")
	public String loginCheck(@Valid @ModelAttribute("user")UserCredentials user,BindingResult bindingResult,HttpServletRequest request)
	{
		if(bindingResult.hasErrors())
		{
			return "index";
		}
		
		UserCredentials us=userDAO.credentialsCheck(user);//check if the userid and password is valid
		if(us!=null)
		{	  ArrayList<Product> cart=new ArrayList<Product>();
			HttpSession session=request.getSession();
			session.setAttribute("userid", us.getUid());//sets the session userid
			session.setAttribute("username", us.getUsername());//sets the session username
			  session.setAttribute("cart", cart);//sets the session cart
			if(user.getUsername().equals("Admin")) //If admin redirects to admin page
			{
			return "mainmenu";
			}
			else  //Or to the Eshop
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
