package com.zhbit.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zhbit.dao.AdvertisementDao;
import com.zhbit.model.Advertisement;

public class AdvertisementDaoImpl implements AdvertisementDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public List<Advertisement> findAllAdervertisement(){
		String hql="from Advertisement";
		List<Advertisement> list=(List<Advertisement>)hibernateTemplate.find(hql);
		return list;
	};
	
	public List<Advertisement> findAdvertisementBySource(String source){	
		String hql="from Advertisement a where a.adSourse='"+source+"'";
		
		List<Advertisement> list=(List<Advertisement>)hibernateTemplate.find(hql);
		return list;
	};

	
}
