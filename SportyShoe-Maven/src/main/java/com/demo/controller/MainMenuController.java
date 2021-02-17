package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Product;

@Controller
public class MainMenuController {

	//Redirects to Main Menu
	@RequestMapping("/ShowMainMenu")
	public String showForm()
	{
		return "mainmenu";
	}
	
	//Redirects to product menu
	@RequestMapping("/showProductMenu")
	public String showProductMenu()
	{
		return "ProductMenu";
	}
	
	//Redirects to product add page
	@RequestMapping("/showProductForm")
	public String showProductManager(Model model)
	{
		model.addAttribute("product",new Product());
		return "ProductAdd";
	}
}
