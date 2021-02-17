package com.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OrderTable")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int oid;
@Temporal(value= TemporalType.TIMESTAMP)
private Date dateofpurchase;
@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
@JoinColumn(name = "productId")
private Product product;
@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
@JoinColumn(name="userId")
private UserCredentials user;

public Order() {
	// TODO Auto-generated constructor stub
}


public Order(int oid, Date date, Product product, UserCredentials user) {
	super();
	this.oid = oid;
	this.dateofpurchase = date;
	this.product = product;
	this.user = user;
}

public int getOid() {
	return oid;
}

public void setOid(int oid) {
	this.oid = oid;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public UserCredentials getUser() {
	return user;
}

public void setUser(UserCredentials user) {
	this.user = user;
}





public Date getDateofpurchase() {
	return dateofpurchase;
}


public void setDateofpurchase(Date dateofpurchase) {
	this.dateofpurchase = dateofpurchase;
}


@Override
public String toString() {
	return "Order [oid=" + oid + ", product=" + product + ", user=" + user + "]";
}

}
