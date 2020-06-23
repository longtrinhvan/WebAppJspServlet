package com.webapp.model;

import java.sql.Date;

public class billModel {
	private int idbill ;
	private int   iduserbuy ;
	private String   fullnamebuy ;
	private int   totalproduct ;
	private int   totalMoney ;
	private Date  datebuy ;
	
	
	public billModel() {
		super();
	}
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public int getIduserbuy() {
		return iduserbuy;
	}
	public void setIduserbuy(int iduserbuy) {
		this.iduserbuy = iduserbuy;
	}
	public String getFullnamebuy() {
		return fullnamebuy;
	}
	public void setFullnamebuy(String fullnamebuy) {
		this.fullnamebuy = fullnamebuy;
	}
	public int getTotalproduct() {
		return totalproduct;
	}
	public void setTotalproduct(int totalproduct) {
		this.totalproduct = totalproduct;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Date getDatebuy() {
		return datebuy;
	}
	public void setDatebuy(Date datebuy) {
		this.datebuy = datebuy;
	}
	
	
}
