package com.demo.DAO;

import org.hibernate.Session;

import com.demo.model.Order;

public interface OrderDAO {
	public void addOrder(Order order);
}
