package com.demo.DAO;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Order;
import com.demo.model.UserCredentials;

@Repository
public class UserDAOimpl implements UserDAO {
	//Session Factory Auto wirirng
	@Autowired
	private SessionFactory sessionFactory;
	
	//Saves user to table
	@Override
	@Transactional
	public void addUser(UserCredentials user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
	}
	//check for credentials in table return null if not
	@Override
	@Transactional
	public UserCredentials credentialsCheck(@Valid UserCredentials user) {
		Session session=sessionFactory.getCurrentSession();
		Query<UserCredentials> query=session.createQuery("From UserCredentials where username=:username and password=:password",UserCredentials.class);
		query.setParameter("username", user.getUsername().trim());
		query.setParameter("password", user.getPassword().trim());
		UserCredentials check=(UserCredentials) query.uniqueResult();
		if(check!=null)
		{
			return check;
		}
		return null;
		
	}
	
	//Get user based on id
	@Override
	@Transactional
	public UserCredentials getUser(int id) {
		Session session=sessionFactory.getCurrentSession();
		UserCredentials user=session.get(UserCredentials.class, id);
		return user;
	}
	
	//Update Password
	@Override
	@Transactional
	public void ChangePassword(String password, int id) {
		Session session=sessionFactory.getCurrentSession();
		UserCredentials user=session.get(UserCredentials.class, id);
		user.setPassword(password);
		session.update(user);
		
		
	}
	//Gell all users
	@Override
	@Transactional
	public ArrayList<UserCredentials> getAllUser() {
		Session session=sessionFactory.getCurrentSession();
		Query<UserCredentials> query=session.createQuery("From UserCredentials",UserCredentials.class);
		ArrayList<UserCredentials> users=(ArrayList<UserCredentials>)query.list();
		return users;
	}
	
	//Get orders based on id
	@Override
	@Transactional
	public List<Order> getOrders(int id) {
		Session session=sessionFactory.openSession();
		UserCredentials user=session.get(UserCredentials.class, id);
		return  user.getOrders();
	}

}
