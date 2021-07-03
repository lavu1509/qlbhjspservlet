package com.bookstore.entity;

import java.sql.Date;

public class Bill {
	private int billID;
	private int accID;
	private int total;
	private Date datebuy;
	
	
	public Bill() {
		super();
	}
	public Bill(int billID, int accID, int total, Date datebuy) {
		super();
		this.billID = billID;
		this.accID = accID;
		this.total = total;
		this.datebuy = datebuy;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getDatebuy() {
		return datebuy;
	}
	public void setDatebuy(Date datebuy) {
		this.datebuy = datebuy;
	}
	
	
	
}
