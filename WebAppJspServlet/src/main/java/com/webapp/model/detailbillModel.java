package com.webapp.model;

public class detailbillModel {
	private int iddetailbill;
	private int idbill;
	private int idproductbuy;
	private String nameproductbuy;
	private int totalproduct;
	private int totalMoneypro;
	
	
	public detailbillModel() {
		super();
	}
	public int getIddetailbill() {
		return iddetailbill;
	}
	public void setIddetailbill(int iddetailbill) {
		this.iddetailbill = iddetailbill;
	}
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public int getIdproductbuy() {
		return idproductbuy;
	}
	public void setIdproductbuy(int idproductbuy) {
		this.idproductbuy = idproductbuy;
	}
	public String getNameproductbuy() {
		return nameproductbuy;
	}
	public void setNameproductbuy(String nameproductbuy) {
		this.nameproductbuy = nameproductbuy;
	}
	public int getTotalproduct() {
		return totalproduct;
	}
	public void setTotalproduct(int totalproduct) {
		this.totalproduct = totalproduct;
	}
	public int getTotalMoneypro() {
		return totalMoneypro;
	}
	public void setTotalMoneypro(int totalMoneypro) {
		this.totalMoneypro = totalMoneypro;
	}
	
	
}
