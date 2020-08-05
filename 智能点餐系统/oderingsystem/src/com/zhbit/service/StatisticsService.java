package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Cart;
import com.zhbit.model.Statistics;

public interface StatisticsService {
	public void saveStatiscis(Cart cart);
	public List<Statistics> findAllStatiscis();
}
