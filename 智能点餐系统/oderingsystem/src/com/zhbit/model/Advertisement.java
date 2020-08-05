package com.zhbit.model;

/**
 * Advertisement entity. @author MyEclipse Persistence Tools
 */

public class Advertisement implements java.io.Serializable {

	// Fields

	private Integer pkAdvertisement;
	private String adId;
	private String admessage;
	private String adImg;
	private String adSourse;

	// Constructors

	/** default constructor */
	public Advertisement() {
	}

	/** full constructor */
	public Advertisement(String adId, String admessage, String adImg, String adSourse) {
		this.adId = adId;
		this.admessage = admessage;
		this.adImg = adImg;
		this.adSourse = adSourse;
	}

	// Property accessors

	public Integer getPkAdvertisement() {
		return this.pkAdvertisement;
	}

	public void setPkAdvertisement(Integer pkAdvertisement) {
		this.pkAdvertisement = pkAdvertisement;
	}

	public String getAdId() {
		return this.adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getAdmessage() {
		return this.admessage;
	}

	public void setAdmessage(String admessage) {
		this.admessage = admessage;
	}

	public String getAdImg() {
		return this.adImg;
	}

	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}

	public String getAdSourse() {
		return this.adSourse;
	}

	public void setAdSourse(String adSourse) {
		this.adSourse = adSourse;
	}

}