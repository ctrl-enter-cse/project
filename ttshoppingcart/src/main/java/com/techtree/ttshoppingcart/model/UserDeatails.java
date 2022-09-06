package com.techtree.ttshoppingcart.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userdetails")
public class UserDeatails {

	@Id
	@Column(name="ID")
	@GeneratedValue(generator = "ProfileIdGenerator")
	@GenericGenerator(name = "ProfileIdGenerator", strategy = "foreign",parameters = @Parameter(name ="property",value = "USER_ID"))
	private int id;
	
	@CreationTimestamp
	@Column(name="CREATION_TIME")
	private Date creationTime;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Users getUSER_ID() {
		return USER_ID;
	}


	public void setUSER_ID(Users uSER_ID) {
		USER_ID = uSER_ID;
	}

	@UpdateTimestamp
	@Column(name="MODIFIED_TIME")
	private Date modifiedTime;
	@Column(name="CREATION_BY")
	private String  creationBy;
	@Column(name="MODIFIED_BY")
	private String  modifiedBy;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="ADDRESS")
	private String address;
	
	
	@Temporal(TemporalType.DATE)
	private  Date DOB;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "userdetail",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Users USER_ID;
	
	

}
