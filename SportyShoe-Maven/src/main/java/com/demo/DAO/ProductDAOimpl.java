package com.demo.DAO;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.demo.model.Product;

@Repository
public class ProductDAOimpl implements ProductDAO {
//session factory autowriring
@Autowired
private SessionFactory sessionFactory;

//adds product to table
@Transactional
public  void addProduct(Product product)
{
	Session session=sessionFactory.getCurrentSession();
	session.save(product);
}
//gets all product from table
@Transactional
public  ArrayList<Product> getProducts()
{
	Session session=sessionFactory.getCurrentSession();
	Query<Product> query=session.createQuery("From Product",Product.class);
	ArrayList<Product> products=(ArrayList<Product>) query.list();
	return products;
}
//Delete product from table
@Transactional
public  void productDelete(int id)
{
	Session session=sessionFactory.getCurrentSession();
	 Product product=session.get(Product.class, id);
	 session.delete(product);
}
//Update product in table
@Transactional
public  void productUpdate(int id, String status) {
	Session session=sessionFactory.getCurrentSession();
	 Product product=session.get(Product.class, id);
	 product.setStatus(status);
	 session.update(product);
}

}
