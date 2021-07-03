package com.bookstore.entity;

public class BillDetail {
	private int bdID;
	private int billID;
	private int proid;
	private int quatity;
	private int bprice;
	
	public BillDetail() {
		// TODO Auto-generated constructor stub
	}

	public BillDetail(int bdID, int billID, int proid, int quatity, int bprice) {
		super();
		this.bdID = bdID;
		this.billID = billID;
		this.proid = proid;
		this.quatity = quatity;
		this.bprice = bprice;
	}

	public int getBdID() {
		return bdID;
	}

	public void setBdID(int bdID) {
		this.bdID = bdID;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
}
