package com.zhbit.daoimpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.dao.OrderDao;
import com.zhbit.model.Cart;
import com.zhbit.model.CartItem;
import com.zhbit.model.Customer;
import com.zhbit.model.Order;
import com.zhbit.model.OrderMessage;
import com.zhbit.model.Tables;

public class OrderDaoImpl implements OrderDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<Order> findAllOrder(){
		
		//获取时间
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		String time=calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}

		/*String hql="from Order o left join Tables t where o.tables=t.pkTables and o.orderTime='"+t+"' and o.nowState='未付款'";      */
		String hql="from Order o where convert(varchar(10),o.orderTime,121)='"+time+"' and o.nowState='未付款'"; 
		List<Order> list=(List<Order>)hibernateTemplate.find(hql);
		
		

		return list;
	};
	
	public void payOrder(String orderid){
		String hql="from Order o where o.orderId='"+orderid+"'";
		List<Order> list=(List<Order>)hibernateTemplate.find(hql);
		Order order=hibernateTemplate.get(Order.class,list.get(0).getPkOrder());
		order.setNowState("已付款");
		hibernateTemplate.save(order);
	};
	
	
	
	
	public String postOrder(Cart cart){
		//要获取持久化对象，故得从hibernate中根据pk获取餐桌和顾客
		
		
		Tables tables=new Tables();//应该由session中获取，现在暂存为空
		tables=hibernateTemplate.get(Tables.class, 1);
		
		
	
		Customer customer=new Customer();//应该由session中获取，现在暂存为空
		customer=hibernateTemplate.get(Customer.class, 1);

		
		/*Timestamp t = new Timestamp(new Date(0).getTime());*/
		Timestamp t = new Timestamp(System.currentTimeMillis()); 
		Order order=new Order();
		int orderNum;
		String hql1="from Order";
		List<Order> list2=(List<Order>) hibernateTemplate.find(hql1);
		if(list2.size()==0){
			 orderNum=1;
		}else{
		int size2=list2.size()-1;
		orderNum=list2.get(size2).getPkOrder()+1;}
		
		
		
		order.setOrderId("00"+orderNum);
		order.setTotlaPrice(cart.getTotalPrice());
		order.setNowState("未付款");
		order.setOrderTime(t);
		order.setCustomer(customer);
		order.setTables(tables);
				
		String hql="from OrderMessage";
		List<OrderMessage> list1=(List<OrderMessage>) hibernateTemplate.find(hql);
		int size=0,i=0;
		if(list1.size()==0){
			size=1;
		}else{
		
		size=list1.size()-1;
		i=list1.get(size).getPkMessage();}
		
		
		for(CartItem cartItem:cart.getCartItems()){
			i++;
			OrderMessage orderMessage=new OrderMessage();
			orderMessage.setOrderMessageId("00000"+i);
			orderMessage.setFood(cartItem.getFood());
			orderMessage.setFoodNumber(cartItem.getCount());
			orderMessage.setFood(cartItem.getFood());
			orderMessage.setOrder(order);
			order.getOrderMessages().add(orderMessage);
		}

		hibernateTemplate.saveOrUpdate(order);	
		return "00"+orderNum;
	}
	
	
	
	
	
}
