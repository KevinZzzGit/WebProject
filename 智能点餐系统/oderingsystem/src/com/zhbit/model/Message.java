package com.zhbit.model;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer pkMessage;
	private Customer customer;
	private String messageId;
	private Timestamp leaveTime;
	private String words;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(String messageId, Timestamp leaveTime) {
		this.messageId = messageId;
		this.leaveTime = leaveTime;
	}

	/** full constructor */
	public Message(Customer customer, String messageId, Timestamp leaveTime, String words) {
		this.customer = customer;
		this.messageId = messageId;
		this.leaveTime = leaveTime;
		this.words = words;
	}

	// Property accessors

	public Integer getPkMessage() {
		return this.pkMessage;
	}

	public void setPkMessage(Integer pkMessage) {
		this.pkMessage = pkMessage;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Timestamp getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getWords() {
		return this.words;
	}

	public void setWords(String words) {
		this.words = words;
	}

}