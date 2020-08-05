package com.zhbit.dao;

import java.util.List;

import com.zhbit.model.Food;

public interface FoodDao {
	//��������ʾ
	public List<Food> foodShow(String classify);
	
	//���ҷ��� Ӧд��food�У��Ժ�����ʱ�޸�
	public Food findfood(Integer pkFood);
	//�޸�ʳ��
	public void reviseFood(Food food);
	
	public boolean addFood(Food food);
	
	public boolean removeFood(Food food);
	
}
