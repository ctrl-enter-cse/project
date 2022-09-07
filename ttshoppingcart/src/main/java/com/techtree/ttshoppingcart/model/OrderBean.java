package com.techtree.ttshoppingcart.model;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.format.annotation.DateTimeFormat;



public class OrderBean {
	
	private int ID;
	
	private  String itemname;
	private double amount;
	private int userid;
//	private int TRANSACTIONS_ID;
	private int no_of_item;
	
//	@DateTimeFormat(pattern="yyyy-MMMM-dd HH:MM:SS")
//	private Date T_DATE;
	
	private double  BILL_AMOUNT;
	private double  DISCOUNT_AMOUNT;
	private double PAID_AMOUNT;

//	enum statustype{
//		canceled,confimerd,pending,inisitated,Refunded,Failed
//	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Enumerated(EnumType.STRING)
	private statustype TRANSCATION_STATUS;

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

//	public int getTRANSACTIONS_ID() {
//		return TRANSACTIONS_ID;
//	}
//
//	public void setTRANSACTIONS_ID(int tRANSACTIONS_ID) {
//		TRANSACTIONS_ID = tRANSACTIONS_ID;
//	}

	public int getNo_of_item() {
		return no_of_item;
	}

	public void setNo_of_item(int no_of_item) {
		this.no_of_item = no_of_item;
	}

//	public Date getT_DATE() {
//		return T_DATE;
//	}
//
//	public void setT_DATE(Date t_DATE) {
//		T_DATE = t_DATE;
//	}

	public double getBILL_AMOUNT() {
		return BILL_AMOUNT;
	}

	public void setBILL_AMOUNT(double bILL_AMOUNT) {
		BILL_AMOUNT = bILL_AMOUNT;
	}

	public double getDISCOUNT_AMOUNT() {
		return DISCOUNT_AMOUNT;
	}

	public void setDISCOUNT_AMOUNT(double dISCOUNT_AMOUNT) {
		DISCOUNT_AMOUNT = dISCOUNT_AMOUNT;
	}

	public double getPAID_AMOUNT() {
		return PAID_AMOUNT;
	}

	public void setPAID_AMOUNT(double pAID_AMOUNT) {
		PAID_AMOUNT = pAID_AMOUNT;
	}

	public statustype getTRANSCATION_STATUS() {
		return TRANSCATION_STATUS;
	}

	public void setTRANSCATION_STATUS(statustype tRANSCATION_STATUS) {
		TRANSCATION_STATUS = tRANSCATION_STATUS;
	}


}
