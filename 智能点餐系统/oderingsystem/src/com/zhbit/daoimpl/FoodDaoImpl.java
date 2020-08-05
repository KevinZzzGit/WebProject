package com.zhbit.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.dao.FoodDao;
import com.zhbit.model.Customer;
import com.zhbit.model.Food;

public class FoodDaoImpl implements FoodDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	//按类别展示菜品
	public List<Food> foodShow(String classify){		
		
		if(classify.equals("all")){
			String hql="from Food";
			List<Food> list=(List<Food>) hibernateTemplate.find(hql);
			return list;
		}
		if(classify.equals("taocan")){classify="套餐";}
		if(classify.equals("xinpin")){classify="新品";}	
		if(classify.equals("tesecai")){classify="特色菜";}	
		if(classify.equals("guodi")){classify="锅底";}	
		if(classify.equals("roulei")){classify="肉类";}	
		if(classify.equals("sulei")){classify="素类";}	
		if(classify.equals("wanhualei")){classify="丸滑类";}	
		if(classify.equals("shanzhenjunlei")){classify="山珍菌类";}	
		if(classify.equals("zhushi")){classify="主食";}	
		if(classify.equals("xiaochi")){classify="小吃";}
		if(classify.equals("yinpin")){classify="饮品";}	
		String hql="from Food f where f.classify='"+classify+"'";
		List<Food> list=(List<Food>) hibernateTemplate.find(hql);
		return list;
	};
	//根据食物单项信息查找
	public Food findfood(Integer pkFood){
		String hql="from Food f where f.pkFood='"+pkFood+"'";
		Food food=new Food();
		List<Food> list=(List<Food>) hibernateTemplate.find(hql);		
		food.setPkFood(list.get(0).getPkFood());
		food.setFoodId(list.get(0).getFoodId());
		food.setFoodName(list.get(0).getFoodName());		
		food.setFoodPrice(list.get(0).getFoodPrice());
		food.setFoodRemark(list.get(0).getFoodRemark());
		food.setClassify(list.get(0).getClassify());
		food.setFoodPicture(list.get(0).getFoodPicture());
		/*Food food=hibernateTemplate.get(Food.class,pkFood);*/
		return food;
	};
	
	
	
	//修改食物
	public void reviseFood(Food food){		
/*		Food myFood=hibernateTemplate.get(Food.class, food.getPkFood());
		myFood=food;*/
		hibernateTemplate.update(food);
	};
	//添加食物
	public boolean addFood(Food food){
		String hql="from Food";
		List<Food> list=(List<Food>) hibernateTemplate.find(hql);		
		
		int i=list.get(list.size()-1).getPkFood()+1;
		System.out.println(i);
		food.setFoodId("00"+i);
		
		hibernateTemplate.save(food);	
		return true;
	}
	//删除食物
	public boolean removeFood(Food food){
		hibernateTemplate.delete(food);		
		return true;
	}
	
	
	
	
	
	
}
