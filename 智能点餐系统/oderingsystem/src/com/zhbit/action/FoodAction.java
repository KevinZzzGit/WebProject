package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.model.Food;
import com.zhbit.service.FoodService;

public class FoodAction extends ActionSupport {
	@Resource
	private FoodService foodService;
	private Integer pkFood;
	private String foodId;
	private String foodName;
	private String foodPicture;
	private Double foodPrice;
	private String foodRemark;
	private String classify="all";
	private Food food=new Food();
	
	
	public void setPkFood(Integer pkFood) {
		this.pkFood = pkFood;
	}


	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}


	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public void setFoodPicture(String foodPicture) {
		this.foodPicture = foodPicture;
	}


	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}


	public void setFoodRemark(String foodRemark) {
		this.foodRemark = foodRemark;
	}


	public void setClassify(String classify) {
		this.classify = classify;
	}


	public void setFood() {		
		food.setFoodId(foodId);
		food.setFoodName(foodName);
		food.setFoodPrice(foodPrice);
		food.setFoodPicture(foodPicture);
		food.setFoodRemark(foodRemark);
		food.setClassify(classify);
	}

//��ѯ����
	public String findAllFood(){
		List<Food> list=foodService.foodShow("all");
		ActionContext.getContext().getSession().put("foodList", list);
		return "findAllFood";
	}
	
//���ʳ��
	public String addFood(){
		setFood();
		boolean flag=foodService.addFood(food);
		return "addFood";
	}
//ɾ��ʳ���ˢ��ǰ�˵�ʳ���б�	
	public String removeFood(){
		setFood();
		food.setPkFood(pkFood);
		boolean flag=foodService.removeFood(food);
		List<Food> list=foodService.foodShow("all");
		ActionContext.getContext().getSession().put("foodList", list);
		return"removeFood";
	}
	
//�޸�ʳ����Ϣ��д
	public String reviseFoodMsg(){
		food=foodService.findfood(pkFood);
		ActionContext.getContext().getSession().put("reviseFoodMsg", food);	
		return SUCCESS;
	}
//�޸�ʳ����Ϣ	
	public String reviseFood(){
		setFood();
		food.setPkFood(pkFood);		
		foodService.reviseFood(food);
		
		return"reviseFood";
		
	}
//�����չʾʳ��
	public String findFoodByClassify(){
		HttpServletRequest request = ServletActionContext.getRequest();	
		String classify=request.getParameter("classify");
		
		if(classify!=""){
			System.out.println("classify="+classify);
			List<Food> list=foodService.foodShow(classify);
			ActionContext.getContext().getSession().put("foodList", list);			
			return "menu";
		}else{
			List<Food> list=foodService.foodShow("all");
			ActionContext.getContext().getSession().put("foodList", list);			
			return SUCCESS;
		}
	}


	
	
	
	
	
	
	
	
	
	
}
