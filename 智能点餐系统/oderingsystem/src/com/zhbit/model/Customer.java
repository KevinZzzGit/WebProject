package com.zhbit.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Integer pkCustomer;
	private String customerId;
	private String cpassword;
	private String cname;
	private String cbirthday;
	private String cphonenumber;
	private Set messages = new HashSet(0);
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String customerId, String cpassword, String cname, String cbirthday, String cphonenumber) {
		this.customerId = customerId;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cbirthday = cbirthday;
		this.cphonenumber = cphonenumber;
	}

	/** full constructor */
	public Customer(String customerId, String cpassword, String cname, String cbirthday, String cphonenumber,
			Set messages, Set orders) {
		this.customerId = customerId;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cbirthday = cbirthday;
		this.cphonenumber = cphonenumber;
		this.messages = messages;
		this.orders = orders;
	}

	// Property accessors

	public Integer getPkCustomer() {
		return this.pkCustomer;
	}

	public void setPkCustomer(Integer pkCustomer) {
		this.pkCustomer = pkCustomer;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCpassword() {
		return this.cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		if(cname==null){this.cname="¹Ë¿Í»áÔ±";}
		this.cname = cname;
	}

	public String getCbirthday() {
		
		return this.cbirthday;
	}

	public void setCbirthday(String cbirthday) {
		if(cbirthday==null){this.cbirthday="2020-5-6";}
		this.cbirthday = cbirthday;
	}

	public String getCphonenumber() {
		return this.cphonenumber;
	}

	public void setCphonenumber(String cphonenumber) {
		this.cphonenumber = cphonenumber;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}