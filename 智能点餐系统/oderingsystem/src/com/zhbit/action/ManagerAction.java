package com.zhbit.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.model.Manager;
import com.zhbit.service.ManagerService;

public class ManagerAction extends ActionSupport {
	@Resource
	private ManagerService managerService;
	private Integer pkManager;
	private String managerId;
	private String mname;
	private String mpassword;
	private Manager manager=new Manager();
	
	
	public void setPkManager(Integer pkManager) {
		this.pkManager = pkManager;
	}



	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public void setManager(){
		manager.setManagerId(managerId);
		manager.setMname(mname);
		manager.setMpassword(mpassword);
		manager.setPkManager(pkManager);
	}


	public String managerLogin(){
		setManager();

		boolean flag=managerService.managerLogin(manager);
		if(flag){return SUCCESS;}else{
		ActionContext.getContext().getSession().put("errormsg","用户名与密码不匹配！");
		return "false";}
	}
}
