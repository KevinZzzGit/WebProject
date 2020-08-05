package com.zhbit.dao;

import java.util.List;
import com.zhbit.model.Waiter;

public interface WaiterDao {
		public boolean waiterLogin(Waiter waiter);
		//É¾³ı
		public int delete(Integer pkWaiter);
		//²éÑ¯
		public List<Waiter> findAll();
		//Ôö¼Ó
		public int save(Waiter d);
}
