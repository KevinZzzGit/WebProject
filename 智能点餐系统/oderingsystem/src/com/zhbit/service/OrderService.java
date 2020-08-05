package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Cart;
import com.zhbit.model.Order;


public interface OrderService {
	public List<Order> findAllOrder();
	public String postOrder(Cart cart);
	public void payOrder(String orderid);
}
