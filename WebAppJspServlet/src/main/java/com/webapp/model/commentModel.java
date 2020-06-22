package com.webapp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class commentModel {
	private int idcomment;
	private int idusercomment;
	private String textcomment;
	private Date datecomment;

	private userModel usermodel = new userModel();
	private List<replyModel> replymodel = new ArrayList<replyModel>();

	public commentModel() {
		super();
	}

	public int getIdcomment() {
		return idcomment;
	}

	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}

	public int getIdusercomment() {
		return idusercomment;
	}

	public void setIdusercomment(int idusercomment) {
		this.idusercomment = idusercomment;
	}

	public String getTextcomment() {
		return textcomment;
	}

	public void setTextcomment(String textcomment) {
		this.textcomment = textcomment;
	}

	public Date getDatecomment() {
		return datecomment;
	}

	public void setDatecomment(Date datecomment) {
		this.datecomment = datecomment;
	}

	public userModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(userModel usermodel) {
		this.usermodel = usermodel;
	}

	public List<replyModel> getReplymodel() {
		return replymodel;
	}

	public void setReplymodel(List<replyModel> replymodel) {
		this.replymodel = replymodel;
	}

}
