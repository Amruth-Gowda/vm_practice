package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custId;

	@Column(name = "cust_firstname")
	private String custFirstname;

	@Column(name = "cust_lastname")
	private String custLastname;

	@Column(name = "cust_email")
	private String custEmail;

	public Customer() {
	}

	public Customer(int custId, String custFirstname, String custLastname, String custEmail) {
		super();
		this.custId = custId;
		this.custFirstname = custFirstname;
		this.custLastname = custLastname;
		this.custEmail = custEmail;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustFirstname() {
		return custFirstname;
	}

	public void setCustFirstname(String custFirstname) {
		this.custFirstname = custFirstname;
	}

	public String getCustLastname() {
		return custLastname;
	}

	public void setCustLastname(String custLastname) {
		this.custLastname = custLastname;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		return "[" + custId + ", " + custFirstname + ", " + custLastname + ", " + custEmail + "]";
	}
}
