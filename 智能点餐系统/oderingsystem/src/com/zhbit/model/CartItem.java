package com.zhbit.model;

public class CartItem {
	private Food food;
	private int count;
	private double counts;
	public double getCounts() {
		return count*food.getFoodPrice();
	}
	public void setCounts(double counts) {
		this.counts = counts;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
