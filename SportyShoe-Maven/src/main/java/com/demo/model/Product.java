package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pid;

@NotNull(message = "is required")
@Size(min=1,message="is required")
@NotBlank(message="is required")
private String name;

@NotNull(message = "is required")
@Size(min=1,message="is required")
@NotBlank(message="is required")
private String category;

@OneToMany(mappedBy = "product",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
private List<Order> orders;

private String status;

public Product() {
	
}
public Product(int pid, @NotNull String name, @NotNull String category, List<Order> orders) {
	super();
	this.pid = pid;
	this.name = name;
	this.category = category;
	this.orders = orders;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public List<Order> getOrders() {
	return orders;
}
public void setOrders(List<Order> orders) {
	this.orders = orders;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", name=" + name + ", category=" + category + ", orders=" + orders + "]";
}

}
