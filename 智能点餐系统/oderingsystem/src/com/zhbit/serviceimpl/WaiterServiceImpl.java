package com.zhbit.serviceimpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.WaiterDao;
import com.zhbit.model.Waiter;
import com.zhbit.service.WaiterService;

@Transactional
public class WaiterServiceImpl implements WaiterService {
	
	@Resource
	private WaiterDao waiterDao;
	
	public boolean waiterLogin(Waiter waiter){
		
		
		return waiterDao.waiterLogin(waiter);
	};
	
	
	
	
	
	//É¾³ý
		public boolean delete(Integer pkWaiter) {
			// TODO Auto-generated method stub
			int aa=waiterDao.delete(pkWaiter);
			if(aa==0){
				return true;
			}else{
				return false;
			}
		}
		//²éÑ¯
		public List<Waiter> findAll() {
			// TODO Auto-generated method stub
			return waiterDao.findAll();
		}
		//Ôö¼Ó
		public boolean save(Waiter d) {
			// TODO Auto-generated method stub
			int aa=waiterDao.save(d);
			if(aa==0){
				return true;
			}else{
				return false;
			}
		}
	
}
