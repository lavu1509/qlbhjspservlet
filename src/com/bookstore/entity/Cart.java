package com.bookstore.entity;

import java.util.List;

public class Cart {
	private int cartID;
	private List<CartItems> cartitem;
	private int status;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Cart(int cartID, List<CartItems> cartitem, int status) {
		super();
		this.cartID = cartID;
		this.cartitem = cartitem;
		this.status = status;
	}



	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	

	public List<CartItems> getCartitem() {
		return cartitem;
	}

	public void setCartitem(List<CartItems> cartitem) {
		this.cartitem = cartitem;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
