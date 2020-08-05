package com.zhbit.model;

/**
 * OrderMessage entity. @author MyEclipse Persistence Tools
 */

public class OrderMessage implements java.io.Serializable {

	// Fields

	private Integer pkMessage;
	private Food food;
	private Order order;
	private String orderMessageId;
	private Integer foodNumber;

	// Constructors

	/** default constructor */
	public OrderMessage() {
	}

	/** minimal constructor */
	public OrderMessage(String orderMessageId, Integer foodNumber) {
		this.orderMessageId = orderMessageId;
		this.foodNumber = foodNumber;
	}

	/** full constructor */
	public OrderMessage(Food food, Order order, String orderMessageId, Integer foodNumber) {
		this.food = food;
		this.order = order;
		this.orderMessageId = orderMessageId;
		this.foodNumber = foodNumber;
	}

	// Property accessors

	public Integer getPkMessage() {
		return this.pkMessage;
	}

	public void setPkMessage(Integer pkMessage) {
		this.pkMessage = pkMessage;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrderMessageId() {
		return this.orderMessageId;
	}

	public void setOrderMessageId(String orderMessageId) {
		this.orderMessageId = orderMessageId;
	}

	public Integer getFoodNumber() {
		return this.foodNumber;
	}

	public void setFoodNumber(Integer foodNumber) {
		this.foodNumber = foodNumber;
	}

}