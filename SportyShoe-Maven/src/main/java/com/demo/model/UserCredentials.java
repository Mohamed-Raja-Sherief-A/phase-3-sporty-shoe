package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class UserCredentials {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int uid;

@NotNull(message = "is required")
@Size(min=1,message="is required")
@NotBlank(message="is required")
@Column(unique = true,length = 20)
private String username;

@NotNull(message = "is required")
@Size(min=1,message="is required")
@NotBlank(message="is required")
private String password;

@OneToMany(mappedBy = "user", fetch = FetchType.LAZY ,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
private List<Order> orders;

public UserCredentials() {
	// TODO Auto-generated constructor stub
}
public UserCredentials(int uid, @NotNull(message = "is required") @Size(min = 1, message = "is required") String username,
		@NotNull(message = "is required") @Size(min = 1, message = "is required") String password, List<Order> orders) {
	super();
	this.uid = uid;
	this.username = username;
	this.password = password;
	this.orders = orders;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Order> getOrders() {
	return orders;
}
public void setOrders(List<Order> orders) {
	this.orders = orders;
}

}
