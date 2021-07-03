package com.bookstore.entity;

import java.io.Serializable;


public class CartItems implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int orderID;
	private Product product;
	private int soluong;
	private int gia;
	
	public CartItems() {
		// TODO Auto-generated constructor stub
	}
	


	public CartItems(int orderID, Product product, int soluong, int gia) {
		super();
		this.orderID = orderID;
		this.product = product;
		this.soluong = soluong;
		this.gia = gia;
	}
	
	


	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
