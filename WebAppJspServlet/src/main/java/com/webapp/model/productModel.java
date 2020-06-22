package com.webapp.model;

public class productModel {
	private int idproduct;
	private String nameproduct;
	private int price;
	private int marketprice;
	private int statusid;
	private String image;
	private int producerid;
	private int total;
	public productModel() {
		super();
	}
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public String getNameproduct() {
		return nameproduct;
	}
	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(int marketprice) {
		this.marketprice = marketprice;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getProducerid() {
		return producerid;
	}
	public void setProducerid(int producerid) {
		this.producerid = producerid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
