package com.techtree.ttshoppingcart.model;

public class response {
	private int walletid;
	private String cashbackExpiry ;
	private String  amountStatus ;
	private Double 	paidAmount ;
	private Double  cashbackAmount;
	private String transcationStatus;
	private String email;
	private String firstName;
	private String lastName;
	private String phonenumber;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getWalletid() {
		return walletid;
	}
	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}
	public String getCashbackExpiry() {
		return cashbackExpiry;
	}
	public void setCashbackExpiry(String cashbackExpiry) {
		this.cashbackExpiry = cashbackExpiry;
	}
	public String getAmountStatus() {
		return amountStatus;
	}
	public void setAmountStatus(String amountStatus) {
		this.amountStatus = amountStatus;
	}
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Double getCashbackAmount() {
		return cashbackAmount;
	}
	public void setCashbackAmount(Double cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}
	public String getTranscationStatus() {
		return transcationStatus;
	}
	public void setTranscationStatus(String transcationStatus) {
		this.transcationStatus = transcationStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
