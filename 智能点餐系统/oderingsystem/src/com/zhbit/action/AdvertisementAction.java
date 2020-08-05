package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.model.Advertisement;
import com.zhbit.service.AdvertisementService;

public class AdvertisementAction extends ActionSupport {
	
	@Resource
	private AdvertisementService advertisementService;
	
	private Integer pkAdvertisement;
	private String adId;
	private String admessage;
	private String adImg;
	private String adSourse;
	public void setPkAdvertisement(Integer pkAdvertisement) {
		this.pkAdvertisement = pkAdvertisement;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public void setAdmessage(String admessage) {
		this.admessage = admessage;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
	public void setAdSourse(String adSourse) {
		this.adSourse = adSourse;
	}
	public void setAdvertisementService(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}

	
	public String findAdvertisementBySource(){
	List<Advertisement> list1=advertisementService.findAdvertisementBySource(adSourse);
	ActionContext.getContext().getSession().put("nowadvertisementList",list1);
		return "findAdvertisementBySource";
	}
	

	public String findAllAdvertisement(){
		List<Advertisement> list=advertisementService.findAllAdervertisement();
		ActionContext.getContext().getSession().put("advertisementList",list);
		return "findAllAdvertisement";
	}
}
