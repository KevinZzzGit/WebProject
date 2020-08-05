package com.zhbit.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.AdvertisementDao;
import com.zhbit.model.Advertisement;
import com.zhbit.service.AdvertisementService;
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {
	@Resource
	AdvertisementDao advertisementDao;
	public List<Advertisement> findAdvertisementBySource(String source){
		return advertisementDao.findAdvertisementBySource(source);
	};
	public List<Advertisement> findAllAdervertisement(){
		return advertisementDao.findAllAdervertisement();
	};
	
}
