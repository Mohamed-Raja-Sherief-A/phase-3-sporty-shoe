package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.UserCredentials;

@Controller
public class LogOutController {
@RequestMapping("/LogOut")
public String logOut(HttpServletRequest request,Model model)
{
	HttpSession session=request.getSession();
	  session.setAttribute("userid", null);
	  session.setAttribute("username", null);
	  session.setAttribute("cart", null);
	  session.invalidate();
	  model.addAttribute("user",new UserCredentials());
	  return "index";
}
}
