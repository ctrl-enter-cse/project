package com.techtree.ttshoppingcart.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@CreationTimestamp
	private Date CREATION_TIME;
	@UpdateTimestamp
	private Date MODIFIED_TIME;
	private String  CREATION_BY;
	private String  MODIFIED_BY;
	
	@DateTimeFormat(pattern="yyyy-mm-dd HH:MM:SS")
	private Date T_DATE;
	
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private orders order_id;
	
	private double  BILL_AMOUNT;
	private double  DISCOUNT_AMOUNT;
	private double PAID_AMOUNT;
	
	@Enumerated(EnumType.STRING)
	private statustype TRANSCATION_STATUS;
		
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Users USER;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getT_DATE() {
		return T_DATE;
	}
	public void setT_DATE(Date t_DATE) {
		T_DATE = t_DATE;
	}
//	public orders getOrder_id() {
//		return order_id;
//	}
//	public void setOrder_id(orders order_id) {
//		this.order_id = order_id;
//	}
	public statustype getTRANSCATION_STATUS() {
		return TRANSCATION_STATUS;
	}
	public void setTRANSCATION_STATUS(statustype statustype) {
		TRANSCATION_STATUS = statustype;
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
//	public Users getUSER() {
//		return USER;
//	}
//	public void setUSER(Users uSER) {
//		USER = uSER;
//	}
	

	
}
