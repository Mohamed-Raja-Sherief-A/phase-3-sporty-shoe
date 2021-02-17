package com.demo.controller;


import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DAO.OrderDAO;
import com.demo.DAO.ProductDAO;
import com.demo.DAO.UserDAO;
import com.demo.model.Order;
import com.demo.model.Product;
import com.demo.model.UserCredentials;

//Shop Controller

@Controller
public class EShopController {

	//Repository auto wiring
	@Autowired
	private ProductDAO productDAO;
	//Repository auto wiring
	@Autowired
	private UserDAO userDAO;
	//Repository auto wiring
	@Autowired
	private OrderDAO orderDAO;
	
	//Mapping Add to cart action
	@RequestMapping("/AddToCart")
	public String addToCart(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		System.out.println(username);
		int id=Integer.parseInt(request.getParameter("id"));
		for(Product product:productDAO.getProducts())
		{
			if(product.getPid()==id)
			{   
				ArrayList<Product>cart=(ArrayList<Product>)session.getAttribute("cart");//Gets cart from session
				cart.add(product);
				session.setAttribute("cart", cart);//Adds cart to the current session
				request.setAttribute("message", product.getName()+" Added to cart");
				request.setAttribute("products", productDAO.getProducts());
			}
		}
		return "eshop";
	}
	
	//Mapping the main view for Eshop
	@RequestMapping("/Eshop")
	public String viewEshop(HttpServletRequest request)
	{
		
		request.setAttribute("products", productDAO.getProducts());
		return "eshop";
	}
	
	//Mapping the cart view
	@RequestMapping("/CheckCart")
	public String checkCart()
	{
		return "cart";
	}
	
	//Delete Cart mapping
	@RequestMapping("/DeleteCart")
	public String deleteCart(HttpServletRequest request)
	{
		Product temp=new Product();
		int id=Integer.parseInt(request.getParameter("id")); 
		HttpSession session=request.getSession();
		ArrayList<Product>cart=(ArrayList<Product>)session.getAttribute("cart");
		System.out.println("got cart");
		for(Product product:cart)
		{
			if(product.getPid()==id)
			{
				temp=product;
			}
		}
		if(temp!=null)
		{
			cart.remove(temp);//removes the content
			session.setAttribute("cart", cart);//add to the session cart
			request.setAttribute("message", "product removed from cart");
		}
		return "cart";
	}
	
	//Check Out Mapping
	@RequestMapping("/CheckOut")
	public String checkOut(HttpServletRequest request)
	{
		Date date=new Date();
		HttpSession session=request.getSession();
		ArrayList<Product> cart=(ArrayList<Product>) session.getAttribute("cart");
		if(cart.size()==0) {                        //Checks if there is content in cart
			request.setAttribute("message", "Add Product to cart");
			return "cart";}
		int userId= (int) session.getAttribute("userid");
		System.out.println(userId);
		UserCredentials user=userDAO.getUser(userId);
		
		for(Product product:cart)
		{
			Order order=new Order();
			order.setUser(user);
			order.setProduct(product);
			order.setDateofpurchase(date);
			orderDAO.addOrder(order);//calls the method addorder
		}
		request.setAttribute("message", "puchase placed");
		cart.clear();// clears cart
		session.setAttribute("cart", cart);
		return "cart";
		
	}
}
