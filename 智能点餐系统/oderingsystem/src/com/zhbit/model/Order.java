package com.zhbit.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer pkOrder;	
	private Tables tables;
	private Customer customer;
	private String orderId;
	private Double totlaPrice;
	private Timestamp orderTime;
	private String nowState;
	private Set orderMessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(String orderId, Double totlaPrice, Timestamp orderTime,String nowState) {
		this.orderId = orderId;
		this.totlaPrice = totlaPrice;
		this.orderTime = orderTime;
		this.nowState=nowState;
	}

	/** full constructor */
	public Order(Tables tables, Customer customer, String orderId, Double totlaPrice, Timestamp orderTime,
			String nowState,Set orderMessages) {
		this.tables = tables;
		this.customer = customer;
		this.orderId = orderId;
		this.totlaPrice = totlaPrice;
		this.orderTime = orderTime;
		this.nowState=nowState;
		this.orderMessages = orderMessages;
	}

	// Property accessors

	public Integer getPkOrder() {
		return this.pkOrder;
	}

	public void setPkOrder(Integer pkOrder) {
		this.pkOrder = pkOrder;
	}

	public Tables getTables() {
		return this.tables;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getTotlaPrice() {
		return this.totlaPrice;
	}

	public void setTotlaPrice(Double totlaPrice) {
		this.totlaPrice = totlaPrice;
	}

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	
	public String getNowState() {
		return nowState;
	}

	public void setNowState(String nowState) {
		this.nowState = nowState;
	}

	public Set getOrderMessages() {
		return this.orderMessages;
	}

	public void setOrderMessages(Set orderMessages) {
		this.orderMessages = orderMessages;
	}

}