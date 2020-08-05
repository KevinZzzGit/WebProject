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
			//获取对象的id
			Waiter d=hibernateTemplate.get(Waiter.class,pkWaiter);
			//执行删除方法  删除id
			hibernateTemplate.delete(d);
			//删除成功  return 1;
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
		//查询获取全部的数据
		List<Waiter> list=(List<Waiter>) hibernateTemplate.find("from Waiter");
		return list;
	}
	public int save(Waiter d) {
		// TODO Auto-generated method stub
		try {
			//调用我们定义的接口  增加数据
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
