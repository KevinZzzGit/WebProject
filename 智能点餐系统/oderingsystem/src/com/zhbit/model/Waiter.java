package com.zhbit.model;

/**
 * Waiter entity. @author MyEclipse Persistence Tools
 */

public class Waiter implements java.io.Serializable {

	// Fields

	private Integer pkWaiter;
	private String waiterId;
	private String wname;
	private String wpassword;
	private String wphonenumber;

	// Constructors

	/** default constructor */
	public Waiter() {
	}

	/** full constructor */
	public Waiter(String waiterId, String wname, String wpassword, String wphonenumber) {
		this.waiterId = waiterId;
		this.wname = wname;
		this.wpassword = wpassword;
		this.wphonenumber = wphonenumber;
	}

	// Property accessors

	public Integer getPkWaiter() {
		return this.pkWaiter;
	}

	public void setPkWaiter(Integer pkWaiter) {
		this.pkWaiter = pkWaiter;
	}

	public String getWaiterId() {
		return this.waiterId;
	}

	public void setWaiterId(String waiterId) {
		this.waiterId = waiterId;
	}

	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWpassword() {
		return this.wpassword;
	}

	public void setWpassword(String wpassword) {
		this.wpassword = wpassword;
	}

	public String getWphonenumber() {
		return this.wphonenumber;
	}

	public void setWphonenumber(String wphonenumber) {
		this.wphonenumber = wphonenumber;
	}

}