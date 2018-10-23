package com.nana.entities;
// default package
// Generated Oct 18, 2018 5:26:59 PM by Hibernate Tools 4.0.0

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Rcustomer 	 by hbm2java
 */
@Entity
@Table(name = "RCUSTOMER", catalog = "MYREMINDER")
public class Rcustomer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "customer_id", unique = true)
	private String customerId;
	private String customerName;
	private String emailAddress;

	public Rcustomer() {
	}

	public Rcustomer(String customerId, String customerName, String emailAddress) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailAddress = emailAddress;
	}

	@Id
	@Column(name = "customer_id", unique = true, nullable = false)
	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name = "customer_name", nullable = false, length = 50)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "email_address", nullable = false, length = 50)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
