package com.techtree.ttshoppingcart.model;

import java.util.Date;



public class walletResponse {

	private int id;

//	private Date creationTime;
//	private Date modifiedTime;
	private String creationBy;
	private String modifiedBy;
	private double amount;
	private String expiryCashbackDateTime;
	private String amountType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Date getCreationTime() {
//		return creationTime;
//	}
//	public void setCreationTime(Date data) {
//		this.creationTime = data;
//	}
//	public Date getModifiedTime() {
//		return modifiedTime;
//	}
//	public void setModifiedTime(Date modifiedTime) {
//		this.modifiedTime = modifiedTime;
//	}
	public String getCreationBy() {
		return creationBy;
	}
	public void setCreationBy(String creationBy) {
		this.creationBy = creationBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getExpiryCashbackDateTime() {
		return expiryCashbackDateTime;
	}
	public void setExpiryCashbackDateTime(String strCashBackDate) {
		this.expiryCashbackDateTime = strCashBackDate;
	}
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

}
