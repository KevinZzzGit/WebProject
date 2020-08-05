package com.zhbit.daoimpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zhbit.dao.StatisticsDao;
import com.zhbit.model.Cart;
import com.zhbit.model.CartItem;
import com.zhbit.model.Food;
import com.zhbit.model.Statistics;

public class StatisticsDaoImpl implements StatisticsDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	
	public List<Statistics> findAllStatiscis(){
		String hql="from Statistics";		
		List<Statistics> list=(List<Statistics>) hibernateTemplate.find(hql);
		return list;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void saveStatiscis(Cart cart) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		Timestamp t = new Timestamp(System.currentTimeMillis()); 
		
		
		String hql="";	
		hql="from Statistics";
		int i=0;int size;
		List<Statistics> list1=(List<Statistics>) hibernateTemplate.find(hql);
		if(list1.size()==0){
			i=1;
		}else{
		size=list1.size()-1;
		i=list1.get(size).getPkStatistics()+1;
		}
		
		
		for(CartItem cartItem:cart.getCartItems()){	
			Statistics statistics=new Statistics();				
			hql="from Statistics s where s.statisticalObjects='"+cartItem.getFood().getFoodName()+"'";			
			List<Statistics> list=(List<Statistics>) hibernateTemplate.find(hql);
		if(list.size()>0){
			statistics=hibernateTemplate.get(Statistics.class, list.get(0).getPkStatistics());		
			statistics.setStatisticsId(list.get(0).getStatisticsId());
			statistics.setStatisticalNumber(cartItem.getCount()+list.get(0).getStatisticalNumber());
			statistics.setStatisticalTime(date);
			hibernateTemplate.update(statistics);
		}else{
			
			statistics.setStatisticsId("000"+i);i++;
			statistics.setStatisticalObjects(cartItem.getFood().getFoodName());
			statistics.setStatisticalTime(date);
			statistics.setStatisticalNumber(cartItem.getCount());
			hibernateTemplate.save(statistics);
			}
		}
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
