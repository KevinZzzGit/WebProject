package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Food;

public interface FoodService {
	//������չʾʳ��
	public List<Food> foodShow(String classify);
	public Food findfood(Integer pkFood);
	//�޸�ʳ��
	public void reviseFood(Food food);
	//���
	public boolean addFood(Food food);
	public boolean removeFood(Food food);
}
