package com.project.user.bean;

public class Customer {
	private int account_id;
	private String customer_name;
	private String Email;
	private String address;
	private int pancard;
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPancard() {
		return pancard;
	}
	public void setPancard(int pancard) {
		this.pancard = pancard;
	}	
}
