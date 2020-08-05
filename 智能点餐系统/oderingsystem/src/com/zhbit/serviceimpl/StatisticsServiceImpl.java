package com.zhbit.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.StatisticsDao;
import com.zhbit.model.Cart;
import com.zhbit.model.Statistics;
import com.zhbit.service.StatisticsService;
@Transactional
public class StatisticsServiceImpl implements StatisticsService {
	@Resource
	private StatisticsDao statisticsDao;
	@Override
	public void saveStatiscis(Cart cart) {
		statisticsDao.saveStatiscis(cart);
		// TODO Auto-generated method stub		
	}
	public List<Statistics> findAllStatiscis(){
		return statisticsDao.findAllStatiscis();
	}

}
