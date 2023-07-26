package com.example.demo.model;

public class Product{
	
	private Integer productId;
	private String  productName;
	private Integer productPrice;
	private Integer productAmount;
	private String  productDetail;
	
	


	public Product() {
		super();
	}

	public Product(Integer productId, String productName, Integer productPrice, Integer productAmount, String productDetail) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAmount = productAmount;
		this.productDetail = productDetail;
	}
	
	public Integer getproductId() {
		return productId;
	}
	public void setproductId(Integer productId) {
		this.productId = productId;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public Integer getproductPrice() {
		return productPrice;
	}
	public void setproductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getproductAmount() {
		return productAmount;
	}
	public void setproductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}
	public String getproductDetail() {
		return productDetail;
	}
	public void setproductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
	
}
