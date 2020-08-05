package com.zhbit.dao;

import java.util.List;

import com.zhbit.model.Cart;
import com.zhbit.model.Statistics;;
public interface StatisticsDao {
	public void saveStatiscis(Cart cart);
	public List<Statistics> findAllStatiscis();
}
