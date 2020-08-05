package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.model.Customer;
import com.zhbit.service.CustomerService;

public class CustomerAction extends ActionSupport {
	@Resource
	private CustomerService customerService;
	
	
	private Integer pkCustomer;
	private String customerId;
	private String cpassword;
	private String cname;
	private String cbirthday;
	private String cphonenumber;
	private Customer customer=new Customer();
	


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setPkCustomer(Integer pkCustomer) {
		this.pkCustomer = pkCustomer;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCbirthday(String cbirthday) {
		this.cbirthday = cbirthday;
	}
	public void setCphonenumber(String cphonenumber) {
		this.cphonenumber = cphonenumber;
	}
	public void setCustomer(){		
		customer.setCname(cname);
		customer.setCbirthday(cbirthday);
		customer.setCustomerId(customerId);
		customer.setCpassword(cpassword);
		customer.setCphonenumber(cphonenumber);
	}
	
	
	
	
	
	
	
	
	
	//用户登录动作
	public String customerLogin(){
		//创建对象并传入值
	
		customer.setCustomerId(customerId);
		customer.setCpassword(cpassword);
		
		if(customerService.CustomerLogin(customer)){			
			customer=customerService.findCustomerByCustomerId(customerId);
			ActionContext.getContext().getSession().put("Customer",customer);
			return SUCCESS;
		}else{
			ActionContext.getContext().getSession().put("errormsg","用户名与密码不匹配，请重新输入！");
			return "false";
		}


	}
	//用户退出动作  跳过验证
	
	public String customerLogout(){
		if(ActionContext.getContext().getSession().get("Customer")!=null){
		ActionContext.getContext().getSession().put("Customer",null);}
		ActionContext.getContext().getSession().remove("Waiter");
		ActionContext.getContext().getSession().remove("Manager");
		return SUCCESS;
	}

	
	//用户注册
	public String Register(){
		setCustomer();
/*		customer.setCname("顾客会员");
		customer.setCbirthday("2020-10-10");*/
		boolean flag=customerService.Register(customer);
		if(flag){
		return SUCCESS;}else{
			ActionContext.getContext().getSession().put("errormsg","用户信息已存在，请重新设置！");
			return "false";
		}		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//查找所有顾客信息
	public String findAllCustomer(){
		List<Customer> list=customerService.findAllCustomer();
		ActionContext.getContext().getSession().put("customerList", list);
		return "findAllCustomer";
	}
	
	
	
	
	
	
}
