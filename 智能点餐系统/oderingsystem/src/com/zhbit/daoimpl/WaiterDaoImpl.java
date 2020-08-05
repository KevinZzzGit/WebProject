package com.zhbit.daoimpl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zhbit.dao.WaiterDao;
import com.zhbit.model.Waiter;




public class WaiterDaoImpl implements WaiterDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public boolean waiterLogin(Waiter waiter){
		String hql="from Waiter w where w.waiterId ='"+waiter.getWaiterId()
		+"' and w.wpassword='"+waiter.getWpassword()+"'";
		List<Waiter> list=(List<Waiter>) hibernateTemplate.find(hql);
		if(list.size()>0){
			return true;
		}
		
		return false;		
	};
	
	
	
	
	public int delete(Integer pkWaiter) {
		// TODO Auto-generated method stub
		try {
			//��ȡ�����id
			Waiter d=hibernateTemplate.get(Waiter.class,pkWaiter);
			//ִ��ɾ������  ɾ��id
			hibernateTemplate.delete(d);
			//ɾ���ɹ�  return 1;
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return 0;
	}

	public List<Waiter> findAll() {
		// TODO Auto-generated method stub
		//��ѯ��ȡȫ��������
		List<Waiter> list=(List<Waiter>) hibernateTemplate.find("from Waiter");
		return list;
	}
	public int save(Waiter d) {
		// TODO Auto-generated method stub
		try {
			//�������Ƕ���Ľӿ�  ��������
			hibernateTemplate.save(d);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return 0;
	}


}
