package com.zhbit.dao;

import java.util.List;

import com.zhbit.model.Food;

public interface FoodDao {
	//按分类显示
	public List<Food> foodShow(String classify);
	
	//查找方法 应写在food中，稍后整合时修改
	public Food findfood(Integer pkFood);
	//修改食物
	public void reviseFood(Food food);
	
	public boolean addFood(Food food);
	
	public boolean removeFood(Food food);
	
}
