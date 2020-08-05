package com.zhbit.action;

import javax.annotation.Resource;
import com.zhbit.model.Waiter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.service.WaiterService;


import java.util.List;



public class WaiterAction extends ActionSupport {
	@Resource
    private WaiterService waiterService;
	
	private Integer pkWaiter;
	private String waiterId;
	private String wname;
	private String wpassword;
	private String wphonenumber;
	private Waiter TWaiter =new Waiter();
	private List<Waiter> list;

	
	public void setPkWaiter(Integer pkWaiter) {
		this.pkWaiter = pkWaiter;
	}
	public void setWaiterId(String waiterId) {
		this.waiterId = waiterId;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public void setWpassword(String wpassword) {
		this.wpassword = wpassword;
	}
	public void setWphonenumber(String wphonenumber) {
		this.wphonenumber = wphonenumber;
	}

	public List<Waiter> getList() {
		return list;
	}
	public void setList(List<Waiter> list) {
		this.list = list;
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}
	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}
	public void setTWaiter(){
		TWaiter.setPkWaiter(pkWaiter);
		TWaiter.setWaiterId(waiterId);
		TWaiter.setWname(wname);
		TWaiter.setWpassword(wpassword);
		TWaiter.setWphonenumber(wphonenumber);
	}
	
	
	
	public String waiterLogin(){
		setTWaiter();

		boolean flag=waiterService.waiterLogin(TWaiter);		
		if(flag){
			return SUCCESS;
		}else{
		ActionContext.getContext().getSession().put("errormsg","用户名与密码不匹配！");
		return "false";}
	}
	
	
	
	
	//增加服务员
	public String save(){
		setTWaiter();
		waiterService.save(TWaiter);
		return "zengjia";
	}

	//查询服务员
	public String show(){
		list=waiterService.findAll();
		ActionContext.getContext().getSession().put("waiterList",list);
		return "zhanshi";
	}
	
	
	//删除服务员
	public String delete(){
		waiterService.delete(pkWaiter);
		return "shanchu";
	}
}