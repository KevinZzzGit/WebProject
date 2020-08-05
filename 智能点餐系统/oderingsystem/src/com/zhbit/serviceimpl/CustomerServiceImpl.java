package com.zhbit.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.CustomerDao;
import com.zhbit.model.Customer;
import com.zhbit.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Resource
	CustomerDao customerDao;
	
	
	
	//ÓÃ»§µÇÂ¼²Ù×÷
	public boolean CustomerLogin(Customer customer){
		return customerDao.CustomerLogin(customer);
	}; 
	
	public Customer findCustomerByCustomerId(String customerId){
		return customerDao.findCustomerByCustomerId(customerId);
	};
	
	
	
	public boolean Register(Customer customer) {
		return customerDao.Register(customer);	
}
	
	
	
	
	public List<Customer> findAllCustomer(){
		return customerDao.findAllCustomer();
	};
}
