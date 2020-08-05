package com.zhbit.dao;

import java.util.List;

import com.zhbit.model.Advertisement;

public interface AdvertisementDao {
	public List<Advertisement> findAdvertisementBySource(String source);
	public List<Advertisement> findAllAdervertisement();
}
