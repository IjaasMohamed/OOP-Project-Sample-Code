package com.customer;

public class Customer {

	private int idcustomer;
	private String name;
	private String email;
	private String phone;
	private String username;
	private String password;
	public Customer(int idcustomer, String name, String email, String phone, String username, String password) {
		this.idcustomer = idcustomer;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	public int getIdcustomer() {
		return idcustomer;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}
