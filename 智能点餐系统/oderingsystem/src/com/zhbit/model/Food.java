package com.zhbit.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */

public class Food implements java.io.Serializable {

	// Fields

	private Integer pkFood;
	private String foodId;
	private String foodName;
	private String foodPicture;
	private Double foodPrice;
	private String foodRemark;
	private String classify;
	private Set orderMessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(String foodId, String foodName, String foodPicture, Double foodPrice, String foodRemark,
			String classify) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPicture = foodPicture;
		this.foodPrice = foodPrice;
		this.foodRemark = foodRemark;
		this.classify = classify;
	}

	/** full constructor */
	public Food(String foodId, String foodName, String foodPicture, Double foodPrice, String foodRemark,
			String classify, Set orderMessages) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPicture = foodPicture;
		this.foodPrice = foodPrice;
		this.foodRemark = foodRemark;
		this.classify = classify;
		this.orderMessages = orderMessages;
	}

	// Property accessors

	public Integer getPkFood() {
		return this.pkFood;
	}

	public void setPkFood(Integer pkFood) {
		this.pkFood = pkFood;
	}

	public String getFoodId() {
		return this.foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodPicture() {
		return this.foodPicture;
	}

	public void setFoodPicture(String foodPicture) {
		this.foodPicture = foodPicture;
	}

	public Double getFoodPrice() {
		return this.foodPrice;
	}

	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodRemark() {
		return this.foodRemark;
	}

	public void setFoodRemark(String foodRemark) {
		this.foodRemark = foodRemark;
	}

	public String getClassify() {
		return this.classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public Set getOrderMessages() {
		return this.orderMessages;
	}

	public void setOrderMessages(Set orderMessages) {
		this.orderMessages = orderMessages;
	}

}