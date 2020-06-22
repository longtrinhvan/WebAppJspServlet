package com.webapp.model;

import java.sql.Date;

public class replyModel {

	private int idreply;
	private int idcommentreply;
	private int iduserreply;
	private String textreply;
	private Date datereply;
	private userModel usermodel = new userModel();

	public replyModel() {
		super();
	}

	public int getIdreply() {
		return idreply;
	}

	public void setIdreply(int idreply) {
		this.idreply = idreply;
	}

	public int getIdcommentreply() {
		return idcommentreply;
	}

	public void setIdcommentreply(int idcommentreply) {
		this.idcommentreply = idcommentreply;
	}

	public int getIduserreply() {
		return iduserreply;
	}

	public void setIduserreply(int iduserreply) {
		this.iduserreply = iduserreply;
	}

	public String getTextreply() {
		return textreply;
	}

	public void setTextreply(String textreply) {
		this.textreply = textreply;
	}

	public Date getDatereply() {
		return datereply;
	}

	public void setDatereply(Date datereply) {
		this.datereply = datereply;
	}

	public userModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(userModel usermodel) {
		this.usermodel = usermodel;
	}

}
