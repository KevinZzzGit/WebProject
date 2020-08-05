package com.zhbit.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zhbit.dao.CustomerDao;
import com.zhbit.model.Customer;



public class CustomerDaoImpl implements CustomerDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

	public boolean CustomerLogin(Customer customer){
		try {
			String hql="from Customer c where c.customerId='"+customer.getCustomerId()
			+"' and c.cpassword='"+customer.getCpassword()+"'";
			List list=hibernateTemplate.find(hql);
			if(list.size()!=0){
				return true;
			}
			return false;
		} catch (Exception e) {			
			return false;
			// TODO: handle exception
		}
	
	}; 
	
	
	public Customer findCustomerByCustomerId(String customerId){
		String hql="from Customer c where c.customerId='"+customerId+"'";
		List<Customer> list=(List<Customer>)hibernateTemplate.find(hql);
		Integer PkCustomer=list.get(0).getPkCustomer();
		
		
		Customer icustomer=hibernateTemplate.get(Customer.class, PkCustomer);
		
		return icustomer;
	};
	
	
	
	
	public boolean Register(Customer customer) {
		
		try {
			hibernateTemplate.save(customer);return true;
		} catch (Exception e) {
			return false;
		}
			
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//查询所有顾客信息
	public List<Customer> findAllCustomer(){
		String hql="from Customer";
		List<Customer> list=(List<Customer>)hibernateTemplate.find(hql);
		return list;	
	};
}
