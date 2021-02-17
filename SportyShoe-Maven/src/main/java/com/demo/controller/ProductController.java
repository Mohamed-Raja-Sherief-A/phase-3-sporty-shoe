package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DAO.ProductDAO;
import com.demo.model.Product;

@Controller
public class ProductController {

	//Repository auto wiring
	@Autowired
	private ProductDAO productDAO;
	
	//Action to add new product
	@RequestMapping("/ProductAdd")
	public String productAdd(@Valid @ModelAttribute("product") Product product,BindingResult bindingResult,HttpServletRequest request)
	{
		if(bindingResult.hasErrors())
		{
		return "ProductAdd";
		}
		else
		{
			product.setStatus("Active");
			productDAO.addProduct(product);//Method call
			request.setAttribute("message", "Added succesfully");
			return "ProductAdd";
		}
	}
	
	//View products
	@RequestMapping("/ProductView")
	public String productView(HttpServletRequest request)
	{
		request.setAttribute("products", productDAO.getProducts());//Method call
		return "ProductView";
	}
	
	//Product Delete
	@RequestMapping("/ProductDelete")
	public String productDelete(HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		try
		{
			productDAO.productDelete(id);
		}
		catch(Exception e)
		{
			request.setAttribute("message", "Product id "+id+" Does not exist");
			return "ProductView";
		}
		request.setAttribute("message", "Product id "+id+" Deleted");
		return "ProductView";
	}
	
	//Product Status update
	@RequestMapping("/ProductUpdate")
	public String productUpdate(HttpServletRequest request)
	{
		
		int id=Integer.parseInt(request.getParameter("id"));
		String status=request.getParameter("status");
		System.out.println(status);
		productDAO.productUpdate(id,status);//Method call
		request.setAttribute("message", "Product id "+id+" Updated to "+status);
		request.setAttribute("products", productDAO.getProducts());
		return "ProductView";
	}
	
}
