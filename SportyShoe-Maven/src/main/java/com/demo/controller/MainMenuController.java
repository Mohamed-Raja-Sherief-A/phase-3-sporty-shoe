package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Product;

@Controller
public class MainMenuController {

	
	@RequestMapping("/ShowMainMenu")
	public String showForm()
	{
		return "mainmenu";
	}
	@RequestMapping("/showProductMenu")
	public String showProductMenu()
	{
		return "ProductMenu";
	}
	@RequestMapping("/showProductForm")
	public String showProductManager(Model model)
	{
		model.addAttribute("product",new Product());
		return "ProductAdd";
	}
}
