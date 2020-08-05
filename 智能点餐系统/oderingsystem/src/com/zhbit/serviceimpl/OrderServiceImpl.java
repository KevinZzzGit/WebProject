package com.zhbit.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.OrderDao;
import com.zhbit.model.Cart;
import com.zhbit.model.Order;
import com.zhbit.service.OrderService;
@Transactional
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;
	
	public List<Order> findAllOrder(){
		return orderDao.findAllOrder();
	};
	
	public String postOrder(Cart cart){
		return orderDao.postOrder(cart);
	}
	public void payOrder(String orderid){
		orderDao.payOrder(orderid);		
	};
	
}
