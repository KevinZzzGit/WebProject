package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Customer;

public interface CustomerService {
	public boolean CustomerLogin(Customer customer); 
	public boolean Register(Customer customer);
	public List<Customer> findAllCustomer();
	public Customer findCustomerByCustomerId(String customerId);
}
