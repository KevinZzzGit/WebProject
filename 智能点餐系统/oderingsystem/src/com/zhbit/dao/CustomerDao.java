package com.zhbit.dao;

import java.util.List;

import com.zhbit.model.Customer;

public interface CustomerDao {
	
	//用户登录操作
	public boolean CustomerLogin(Customer customer); 
	//用户注册
	public boolean Register(Customer customer);
	
	public List<Customer> findAllCustomer();
	public Customer findCustomerByCustomerId(String customerId);
}	
