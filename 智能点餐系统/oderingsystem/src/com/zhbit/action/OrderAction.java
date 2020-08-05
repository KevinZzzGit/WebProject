package com.zhbit.action;



import java.util.List;

import javax.annotation.Resource;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.model.Cart;
import com.zhbit.model.Customer;
import com.zhbit.model.Order;
import com.zhbit.model.Tables;
import com.zhbit.service.OrderService;
import com.zhbit.service.StatisticsService;
import com.zhbit.service.TablesService;

public class OrderAction extends ActionSupport {
	@Resource(name="TablesService")
	private TablesService tablesService;
	@Resource
	private OrderService orderService;
	@Resource
	private StatisticsService statisticsService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	
	
	public String findAllOrder(){
		List<Order> list=orderService.findAllOrder();
		ActionContext.getContext().getSession().put("orderList", list);
		return "findAllOrder";
	}
	
	
	
	public String payOrder(){
		//餐桌状态调整
		
		Tables tables=(Tables)ActionContext.getContext().getSession().get("tabless");
		
		if(!tables.getOrderState()){
			ActionContext.getContext().getSession().put("errormsg","您已支付成功，请勿重复提交！！");
			return "error";
		}
		
		
		Tables tabless=tablesService.selectTablesId(tables.getPkTables());
		tabless.setTableState(false);tables.setTableState(false);
		tabless.setOrderState(false);tables.setOrderState(false);
		tablesService.updateTable(tabless);
		
		ActionContext.getContext().getSession().put("tables",tables);		
		//修改订单状态
		String orderid=(String)ActionContext.getContext().getSession().get("orderid");
		orderService.payOrder(orderid);
		ActionContext.getContext().getSession().remove("orderid");
		return "payOrder";
	}
	
	
	
	
	
	public String postOrder(){
		Customer customer=(Customer)ActionContext.getContext().getSession().get("Customer");
		Cart cart=(Cart) ActionContext.getContext().getSession().get("cart");
		
		
		Tables table=(Tables)ActionContext.getContext().getSession().get("tabless");
		if(cart==null){System.out.println("cart null");}
		if(table==null){System.out.println("table null");}
		if(customer==null){System.out.println("customer null");}
		
		
		if(cart==null){	
			ActionContext.getContext().getSession().put("errormsg","购物车为空！！");
			return "error";
		}else
		if(table==null){
			ActionContext.getContext().getSession().put("errormsg","请先入座");
			return "error";
		}else if(customer==null){
			ActionContext.getContext().getSession().put("errormsg","请先登陆！！");
			return "error";
		}
		else{			

			
			Tables tabless=tablesService.selectTablesId(table.getPkTables());
			tabless.setTableState(true);table.setTableState(true);
			tabless.setOrderState(true);table.setOrderState(true);
			
			
			System.out.println("餐桌设置");
			tablesService.updateTable(tabless);
			ActionContext.getContext().getSession().put("tabless",table);
			
			
			
			
			
			
			
			String orderid=orderService.postOrder(cart);//提交订单
			ActionContext.getContext().getSession().put("orderid",orderid);
			
			statisticsService.saveStatiscis(cart);//数据存储
			ActionContext.getContext().getSession().put("oldcart",cart);
			ActionContext.getContext().getSession().put("cart",null);
			return "postOrder";
		}
		
	}
	
	
	
}
