package com.techtree.ttshoppingcart.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@CreationTimestamp
	private Date CREATION_TIME;
	@UpdateTimestamp
	private Date MODIFIED_TIME;
	
	private String  CREATION_BY;
	private String  MODIFIED_BY;
	private String  EMAIL;
	private String  PHONENUMBER;
	private String  REGISTRATION;
	private String LAST_LOGIN;
	private String PASSSWORD;
	@Column(name="STATUS_")
	private String UserSTATUS;
	
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	private UserDeatails userdetail;
//	
	
	@JsonIgnore
	@OneToMany(mappedBy ="USER",cascade = CascadeType.ALL)
	private List<Transactions> transactions;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userid",cascade = CascadeType.ALL)
	private List<orders> order;
	
	public int getId() {
		return id;
	}
	
	public List<orders> getOrder() {
		return order;
	}

	public void setOrder(List<orders> order) {
		this.order = order;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	public void setId(int id) {
		this.id = id;
	}
//	public UserDeatails getUserdetail() {
//		return userdetail;
//	}
//	public void setUserdetail(UserDeatails userdetail) {
//		this.userdetail = userdetail;
//	}
	public String getCREATION_BY() {
		return CREATION_BY;
	}
	public void setCREATION_BY(String cREATION_BY) {
		CREATION_BY = cREATION_BY;
	}
	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}
	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONENUMBER() {
		return PHONENUMBER;
	}
	public void setPHONENUMBER(String pHONENUMBER) {
		PHONENUMBER = pHONENUMBER;
	}
	public String getREGISTRATION() {
		return REGISTRATION;
	}
	public void setREGISTRATION(String rEGISTRATION) {
		REGISTRATION = rEGISTRATION;
	}
	public String getLAST_LOGIN() {
		return LAST_LOGIN;
	}
	public void setLAST_LOGIN(String lAST_LOGIN) {
		LAST_LOGIN = lAST_LOGIN;
	}
	public String getPASSSWORD() {
		return PASSSWORD;
	}
	public void setPASSSWORD(String pASSSWORD) {
		PASSSWORD = pASSSWORD;
	}
	public String getUserSTATUS() {
		return UserSTATUS;
	}
	public void setUserSTATUS(String userSTATUS) {
		UserSTATUS = userSTATUS;
	}

	
}
