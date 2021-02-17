package com.demo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Order;


@Repository
public class OrderDAOimpl implements OrderDAO {
	//session factory mapping
	@Autowired
	private SessionFactory sessionFactory;
	
	//adds order to table
	@Override
	@Transactional
	public void addOrder(Order order) {
		Session session=sessionFactory.getCurrentSession();
		session.save(order);
		

	}

}
