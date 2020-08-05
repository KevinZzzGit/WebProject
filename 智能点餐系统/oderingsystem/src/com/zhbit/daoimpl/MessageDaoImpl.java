package com.zhbit.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zhbit.dao.MessageDao;
import com.zhbit.model.Customer;
import com.zhbit.model.Message;


public class MessageDaoImpl implements MessageDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public void postMessage(Message message){
		String hql="from Message";		
		List<Message> list=(List<Message>) hibernateTemplate.find(hql);
		if(list.size()==0){
			message.setMessageId("1");
			Timestamp t=new Timestamp(System.currentTimeMillis()); 
			message.setLeaveTime(t);			
			hibernateTemplate.save(message);
		}else{
			int i=list.size()-1;
			String id=""+(list.get(i).getPkMessage()+1);
			Timestamp t=new Timestamp(System.currentTimeMillis()); 
			message.setLeaveTime(t);
			message.setMessageId(id);
			hibernateTemplate.save(message);
		}
		
		
	};
	
	
	
	public List<Message> findAllStatiscis(){
		String hql="from Message";		
		List<Message> list=(List<Message>) hibernateTemplate.find(hql);
		return list;	
	};
}
