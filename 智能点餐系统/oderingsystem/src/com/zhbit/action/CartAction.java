package com.zhbit.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.model.Cart;
import com.zhbit.model.CartItem;
import com.zhbit.model.Food;
import com.zhbit.service.FoodService;


public class CartAction extends ActionSupport {
	@Resource
	private FoodService foodService;
	private Integer pkFoodid;



	public void setPkFoodid(Integer pkFoodid) {
		this.pkFoodid = pkFoodid;
	}



	public String addCart(){
	
		/*int i=Integer.parseInt(request.getParameter("foodid"));*/
		Food food=foodService.findfood(pkFoodid);
		CartItem cartItem=new CartItem();
		cartItem.setCount(1);
		cartItem.setFood(food);
		Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
		if(cart ==null){
			cart=new Cart();
		}
		cart.addCart(cartItem);
		ActionContext.getContext().getSession().put("cart",cart);
		return "addCart";	
	}
	
	public String clearCart(){
		Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
		if(cart ==null){
			cart=new Cart();
		}
		cart.clearCart();
		ActionContext.getContext().getSession().put("cart",cart);
		return "clearCart";
	}
	public String cutCart(){

		Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
		cart.cutCart(pkFoodid);
		ActionContext.getContext().getSession().put("cart",cart);
		return "cutCart";		
	}
	
	
}
