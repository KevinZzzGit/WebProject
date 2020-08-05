package com.zhbit.serviceimpl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.ManagerDao;
import com.zhbit.model.Manager;
import com.zhbit.service.ManagerService;
@Transactional
public class ManagerServiceImpl implements ManagerService {
	@Resource
	private ManagerDao managerDao;
	
	@Override
	public boolean managerLogin(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.managerLogin(manager);
	}
	
	
	

}
