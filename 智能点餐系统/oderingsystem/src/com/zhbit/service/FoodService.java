package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Food;

public interface FoodService {
	//按分类展示食物
	public List<Food> foodShow(String classify);
	public Food findfood(Integer pkFood);
	//修改食物
	public void reviseFood(Food food);
	//添加
	public boolean addFood(Food food);
	public boolean removeFood(Food food);
}
