package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Advertisement;

public interface AdvertisementService {
	public List<Advertisement> findAdvertisementBySource(String source);
	public List<Advertisement> findAllAdervertisement();
}
