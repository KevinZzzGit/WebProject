package com.zhbit.dao;

import java.util.List;
import com.zhbit.model.Waiter;

public interface WaiterDao {
		public boolean waiterLogin(Waiter waiter);
		//ɾ��
		public int delete(Integer pkWaiter);
		//��ѯ
		public List<Waiter> findAll();
		//����
		public int save(Waiter d);
}
