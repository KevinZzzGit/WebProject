package com.zhbit.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> map=new LinkedHashMap<Integer,CartItem>();
	private double totalPrice;
	private CartItem cartItem;
	
	private Collection<CartItem> cartItems;

	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	public CartItem getCartItem(){
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public Map<Integer, CartItem> getMap() {
		return map;
	}
	
	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	//����
	
	//���
	public void clearCart(){
		map.clear();
		totalPrice=0;
	}
	//�Ƴ�
	public void removeCart(Integer id){
		CartItem cartItem=map.remove(id);
	}
	
	//���
	public void addCart(CartItem cartItem){
		Integer id=cartItem.getFood().getPkFood();
		//�ж��Ƿ����
		if(map.containsKey(id)){			
			CartItem _cartItem =map.get(id);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			
			map.put(id, cartItem);
		}
		totalPrice+=cartItem.getCounts();
	}
	//����
	public void cutCart(Integer id){
		CartItem cartItem =map.get(id);
		if(cartItem.getCount()==1){
			//�����Ƴ�
			removeCart(id);
		}else{
			CartItem _cartItem =map.get(id);
			_cartItem.setCount(_cartItem.getCount()-1);
		}
		totalPrice-=cartItem.getFood().getFoodPrice();
	}
}
