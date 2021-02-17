package com.demo.DAO;



import java.util.ArrayList;

import com.demo.model.Product;

public interface ProductDAO {
	public  void addProduct(Product product);


	public   ArrayList<Product> getProducts();


	public  void productDelete(int id);


	public void productUpdate(int id, String status) ;
}
