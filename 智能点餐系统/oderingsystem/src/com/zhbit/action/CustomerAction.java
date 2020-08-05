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
	
	
	
	
	
	
	
	
	
	//�û���¼����
	public String customerLogin(){
		//�������󲢴���ֵ
	
		customer.setCustomerId(customerId);
		customer.setCpassword(cpassword);
		
		if(customerService.CustomerLogin(customer)){			
			customer=customerService.findCustomerByCustomerId(customerId);
			ActionContext.getContext().getSession().put("Customer",customer);
			return SUCCESS;
		}else{
			ActionContext.getContext().getSession().put("errormsg","�û��������벻ƥ�䣬���������룡");
			return "false";
		}


	}
	//�û��˳�����  ������֤
	
	public String customerLogout(){
		if(ActionContext.getContext().getSession().get("Customer")!=null){
		ActionContext.getContext().getSession().put("Customer",null);}
		ActionContext.getContext().getSession().remove("Waiter");
		ActionContext.getContext().getSession().remove("Manager");
		return SUCCESS;
	}

	
	//�û�ע��
	public String Register(){
		setCustomer();
/*		customer.setCname("�˿ͻ�Ա");
		customer.setCbirthday("2020-10-10");*/
		boolean flag=customerService.Register(customer);
		if(flag){
		return SUCCESS;}else{
			ActionContext.getContext().getSession().put("errormsg","�û���Ϣ�Ѵ��ڣ����������ã�");
			return "false";
		}		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//�������й˿���Ϣ
	public String findAllCustomer(){
		List<Customer> list=customerService.findAllCustomer();
		ActionContext.getContext().getSession().put("customerList", list);
		return "findAllCustomer";
	}
	
	
	
	
	
	
}
