package com.techtree.ttshoppingcart.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="wallets")
public class Wallets {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@CreationTimestamp
	private Date CREATION_TIME;
	@UpdateTimestamp
	private Date MODIFIED_TIME;
	private String  CREATION_BY;
	private String  MODIFIED_BY;
	private double  AMOUNT;
	private String  EXPIRY_CASHBACK_DATE_TIME;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Users  USER_ID;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Transactions TRANCATION_ID ;
	
	private String AMOUNT_STATUS;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public double getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public String getEXPIRY_CASHBACK_DATE_TIME() {
		return EXPIRY_CASHBACK_DATE_TIME;
	}
	public void setEXPIRY_CASHBACK_DATE_TIME(String eXPIRY_CASHBACK_DATE_TIME) {
		EXPIRY_CASHBACK_DATE_TIME = eXPIRY_CASHBACK_DATE_TIME;
	}
	public Users getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(Users uSER_ID) {
		USER_ID = uSER_ID;
	}
	public Transactions getTRANCATION_ID() {
		return TRANCATION_ID;
	}
	public void setTRANCATION_ID(Transactions tRANCATION_ID) {
		TRANCATION_ID = tRANCATION_ID;
	}
	
	public String getAMOUNT_STATUS() {
		return AMOUNT_STATUS;
	}
	public void setAMOUNT_STATUS(String aMOUNT_STATUS) {
		AMOUNT_STATUS = aMOUNT_STATUS;
	}
//	public String getUSER_ID() {
//		return USER_ID;
//	}
//	public void setUSER_ID(String uSER_ID) {
//		USER_ID = uSER_ID;
//	}
//	public String getTRANCATION_ID() {
//		return TRANCATION_ID;
//	}
//	public void setTRANCATION_ID(String tRANCATION_ID) {
//		TRANCATION_ID = tRANCATION_ID;
//	}
	
}
