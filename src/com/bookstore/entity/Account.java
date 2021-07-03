package com.bookstore.entity;

public class Account {
	private int uid;
	private String username;
	private String pass;
	private String email;
	private String fullname;
	private String phone;
	private String address;
	private int isSell;
	private int isAdmin;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int uid, String username, String pass, String email, String fullname, String phone, String address,
			int isSell, int isAdmin) {
		super();
		this.uid = uid;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsSell() {
		return isSell;
	}

	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
