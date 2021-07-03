package com.bookstore.entity;

public class Product {
	private int pid;
	private String pname;
	private String image;
	private int price;
	private String author;
	private String title;
	private String description;
	private String detail;
	private int cateID;
	private int sellID;
	
	
	
	public Product() {
		super();
	}
	
	
	public Product(int pid, String pname, String image, int price, String author, String title, String description,
			String detail, int cateID, int sellID) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.image = image;
		this.price = price;
		this.author = author;
		this.title = title;
		this.description = description;
		this.detail = detail;
		this.cateID = cateID;
		this.sellID = sellID;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", image=" + image + ", price=" + price + ", author="
				+ author + ", title=" + title + ", description=" + description + ", detail=" + detail + ", cateID="
				+ cateID + ", sellID=" + sellID + "]";
	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public int getSellID() {
		return sellID;
	}
	public void setSellID(int sellID) {
		this.sellID = sellID;
	}
	
	
}
