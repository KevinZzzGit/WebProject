package com.zhbit.model;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private Integer pkManager;
	private String managerId;
	private String mname;
	private String mpassword;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(String managerId, String mname, String mpassword) {
		this.managerId = managerId;
		this.mname = mname;
		this.mpassword = mpassword;
	}

	// Property accessors

	public Integer getPkManager() {
		return this.pkManager;
	}

	public void setPkManager(Integer pkManager) {
		this.pkManager = pkManager;
	}

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpassword() {
		return this.mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

}