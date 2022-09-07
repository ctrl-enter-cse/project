package com.techtree.ttshoppingcart.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="orders")
public class orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	
	@CreationTimestamp
	private Date CREATION_TIME;
	
	@UpdateTimestamp
	private Date MODIFIED_TIME;
	
	@Column(name="CREATION_BY")
	private String creationBy;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name="ITEMNAME")
	private  String itemname;


	@Column(name="DATE_")
	private  Date date;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Users userid;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Transactions TRANSACTIONS;
	
	@Column(name="No_Of_Item")
	private int no_of_item;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBcreationy() {
		return creationBy;
	}

	public void setcreationBy(String creationby) {
		creationBy = creationby;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

	public Transactions getTRANSACTIONS() {
		return TRANSACTIONS;
	}

	public void setTRANSACTIONS_ID(Transactions tRANSACTIONS) {
		TRANSACTIONS= tRANSACTIONS;
	}

	public int getNo_of_item() {
		return no_of_item;
	}

	public void setNo_of_item(int no_of_item) {
		this.no_of_item = no_of_item;
	}
	
	
	public String getCreationBy() {
		return creationBy;
	}

	public void setCreationBy(String creationBy) {
		this.creationBy = creationBy;
	}
}
