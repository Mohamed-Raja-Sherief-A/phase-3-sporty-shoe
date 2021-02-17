package com.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DAO.UserDAO;
import com.demo.model.Order;
import com.demo.model.UserCredentials;



@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/UserForm")
	public String userForm(HttpServletRequest request)
	{
		request.setAttribute("users", userDAO.getAllUser());
	 return "UserForm";
	}
@RequestMapping("/ReportGenerator")
public String reportGenerator(HttpServletRequest request)
{
	String userid=request.getParameter("userid");
	
	if(userid.equals("current"))
	{
		System.out.println("inside current");
		request.setAttribute("message", "Enter valid values");
		request.setAttribute("users", userDAO.getAllUser());
		return "UserForm";
	}
	
	int id=(int) Integer.parseInt(request.getParameter("userid"));
	request.setAttribute("orders",userDAO.getOrders(id));
	return "Report";
}
}
