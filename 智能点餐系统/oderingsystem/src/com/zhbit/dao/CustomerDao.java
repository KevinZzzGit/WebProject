package com.zhbit.dao;

import java.util.List;

import com.zhbit.model.Customer;

public interface CustomerDao {
	
	//�û���¼����
	public boolean CustomerLogin(Customer customer); 
	//�û�ע��
	public boolean Register(Customer customer);
	
	public List<Customer> findAllCustomer();
	public Customer findCustomerByCustomerId(String customerId);
}	
