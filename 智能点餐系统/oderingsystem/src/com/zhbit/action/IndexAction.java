package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.service.AdvertisementService;
import com.zhbit.service.FoodService;

import com.zhbit.model.*;
public class IndexAction extends ActionSupport {
	
	@Resource
	private FoodService foodService;
	@Resource
	private AdvertisementService advertisementService;
	
	
	public String tologin(){
		HttpServletRequest request = ServletActionContext.getRequest();  
		String tologin=request.getParameter("tologin");
		
		//û��½���ܷ����ҵĶ���
		if(tologin.equals("pay")){
			Customer customer=(Customer)ActionContext.getContext().getSession().get("Customer");
			if(customer==null){
				ActionContext.getContext().getSession().put("errormsg","�����ȵ�½�ٲ������������ʣ�����з���Ա��");
				return "error";
			}
		}
		
		
		
		
		
		return tologin;			
	}
	
	
	public String adShow(){
		List<Advertisement> list1=advertisementService.findAdvertisementBySource("��������Ļ�");
		ActionContext.getContext().getSession().put("nowadvertisementList",list1);
		return SUCCESS;
	}
	
	public String returnindex(){
		if(ActionContext.getContext().getSession().get("Customer")!=null){
			return SUCCESS;
		}else{
			return "false";			
		}
		
	}
	
	
	
	
	//�Բ�ͬ���ܽ�����תʱִ�еķ�����
	public String pageShow(){
		HttpServletRequest request = ServletActionContext.getRequest();  
		String page=request.getParameter("page");
		
		//�˵�����
		if(page.equals("menupage")){
			//����˵�ҳ�棬��Ĭ�ϵ�һ������ȫ����Ʒ			
			List<Food> list=foodService.foodShow("all");
			ActionContext.getContext().getSession().put("foodList", list);
			
			
			Tables tables=new Tables();
			tables.setTablesId("001");
			tables.setOrderState(false);
			ActionContext.getContext().getSession().put("tables",tables);
			
			

			//�������ﳵ
			Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
			if(cart ==null){
				cart=new Cart();
				ActionContext.getContext().getSession().put("cart",cart);
			}			
			return "menupage";			
		}else
		if(page.equals("userlogin")){

			return "userloginpage";
		}else

		
		if(page.equals("userpage")){
			return "userpage";
		}
		if(page.equals("leavemsg")){
			return "leavemsg";
		}
		else{
			return "ok";
		}
		
		
		
		
		
		
	}
	
}
