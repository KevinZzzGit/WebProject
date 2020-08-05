package com.zhbit.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zhbit.dao.ManagerDao;
import com.zhbit.model.Manager;

public class ManagerDaoImpl implements ManagerDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public boolean managerLogin(Manager manager) {
		String hql="from Manager m where m.managerId='"+manager.getManagerId()
		+"' and m.mpassword='"+manager.getMpassword()+"'";
		List<Manager> list=(List<Manager>)hibernateTemplate.find(hql);
		if(list.size()>0){return true;}
		// TODO Auto-generated method stub
		return false;
	}

}
