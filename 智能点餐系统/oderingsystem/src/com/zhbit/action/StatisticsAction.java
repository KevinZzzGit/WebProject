package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.service.StatisticsService;
import com.zhbit.model.Statistics;;
public class StatisticsAction extends ActionSupport {
	@Resource
	StatisticsService statisticsService; 
	
	
	
	public String findAllStatistics(){
		List<Statistics> list=statisticsService.findAllStatiscis();
		ActionContext.getContext().getSession().put("statisticsList", list);
		return "findAllStatistics";		
	}
}
