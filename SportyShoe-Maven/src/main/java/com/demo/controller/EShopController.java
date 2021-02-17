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


@Controller
public class EShopController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	@RequestMapping("/AddToCart")
	public String addToCart(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		System.out.println(username);
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		for(Product product:productDAO.getProducts())
		{
			if(product.getPid()==id)
			{   
				ArrayList<Product>cart=(ArrayList<Product>)session.getAttribute("cart");
				System.out.println("inside if");
				cart.add(product);
				System.out.println("adding product to array list");
				session.setAttribute("cart", cart);
				System.out.println("adding cart to session");
				request.setAttribute("message", product.getName()+" Added to cart");
				request.setAttribute("products", productDAO.getProducts());
			}
		}
		return "eshop";
	}
	@RequestMapping("/Eshop")
	public String viewEshop(HttpServletRequest request)
	{
		
		request.setAttribute("products", productDAO.getProducts());
		return "eshop";
	}
	@RequestMapping("/CheckCart")
	public String checkCart()
	{
		return "cart";
	}
	@RequestMapping("/DeleteCart")
	public String deleteCart(HttpServletRequest request)
	{
		System.out.println("Inside Delete cart");
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
			cart.remove(temp);
			System.out.println("product removed");
			session.setAttribute("cart", cart);
			System.out.println("Added to session cart");
			request.setAttribute("message", "product removed from cart");
		}
		return "cart";
	}
	@RequestMapping("/CheckOut")
	public String checkOut(HttpServletRequest request)
	{
		Date date=new Date();
		HttpSession session=request.getSession();
		ArrayList<Product> cart=(ArrayList<Product>) session.getAttribute("cart");
		if(cart.size()==0) {
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
			orderDAO.addOrder(order);
		}
		request.setAttribute("message", "puchase placed");
		cart.clear();
		session.setAttribute("cart", cart);
		return "cart";
		
	}
}
