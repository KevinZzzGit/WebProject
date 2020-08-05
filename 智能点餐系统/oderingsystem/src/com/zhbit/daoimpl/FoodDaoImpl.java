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


	//�����չʾ��Ʒ
	public List<Food> foodShow(String classify){		
		
		if(classify.equals("all")){
			String hql="from Food";
			List<Food> list=(List<Food>) hibernateTemplate.find(hql);
			return list;
		}
		if(classify.equals("taocan")){classify="�ײ�";}
		if(classify.equals("xinpin")){classify="��Ʒ";}	
		if(classify.equals("tesecai")){classify="��ɫ��";}	
		if(classify.equals("guodi")){classify="����";}	
		if(classify.equals("roulei")){classify="����";}	
		if(classify.equals("sulei")){classify="����";}	
		if(classify.equals("wanhualei")){classify="�軬��";}	
		if(classify.equals("shanzhenjunlei")){classify="ɽ�����";}	
		if(classify.equals("zhushi")){classify="��ʳ";}	
		if(classify.equals("xiaochi")){classify="С��";}
		if(classify.equals("yinpin")){classify="��Ʒ";}	
		String hql="from Food f where f.classify='"+classify+"'";
		List<Food> list=(List<Food>) hibernateTemplate.find(hql);
		return list;
	};
	//����ʳ�ﵥ����Ϣ����
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
	
	
	
	//�޸�ʳ��
	public void reviseFood(Food food){		
/*		Food myFood=hibernateTemplate.get(Food.class, food.getPkFood());
		myFood=food;*/
		hibernateTemplate.update(food);
	};
	//���ʳ��
	public boolean addFood(Food food){
		String hql="from Food";
		List<Food> list=(List<Food>) hibernateTemplate.find(hql);		
		
		int i=list.get(list.size()-1).getPkFood()+1;
		System.out.println(i);
		food.setFoodId("00"+i);
		
		hibernateTemplate.save(food);	
		return true;
	}
	//ɾ��ʳ��
	public boolean removeFood(Food food){
		hibernateTemplate.delete(food);		
		return true;
	}
	
	
	
	
	
	
}
