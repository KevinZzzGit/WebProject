package com.zhbit.serviceimpl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import com.zhbit.model.Food;
import com.zhbit.service.FoodService;
import com.zhbit.dao.FoodDao;
@Transactional
public class FoodServiceImpl implements FoodService {
	@Resource
	FoodDao foodDao;

	public List<Food> foodShow(String classify){
		return foodDao.foodShow(classify);
	};
	
	public Food findfood(Integer pkFood){
		return foodDao.findfood(pkFood);
	}
	
	//ÐÞ¸ÄÊ³Îï
	public void reviseFood(Food food){
		foodDao.reviseFood(food);
	};
	
	public boolean addFood(Food food){
		return foodDao.addFood(food);
	};
	
	public boolean removeFood(Food food){
		
		return foodDao.removeFood(food);
		
	}
	
	
}
