package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Order;
import com.demo.model.UserCredentials;

public interface UserDAO {
public void addUser(UserCredentials user);

public UserCredentials credentialsCheck(@Valid UserCredentials user);

public  UserCredentials getUser(int id);

public  void ChangePassword(String password,int id);

public  ArrayList<UserCredentials> getAllUser();

public List<Order> getOrders(int id);
}
