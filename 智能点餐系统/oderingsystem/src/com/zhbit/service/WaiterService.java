package com.zhbit.service;

import java.util.List;


import com.zhbit.model.Waiter;

public interface WaiterService {
	public boolean waiterLogin(Waiter waiter);
	public List<Waiter> findAll();
	public boolean delete(Integer pkWaiter);
	public boolean save(Waiter d);
}
