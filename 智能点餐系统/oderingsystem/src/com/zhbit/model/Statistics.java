package com.zhbit.model;

import java.util.Date;

/**
 * Statistics entity. @author MyEclipse Persistence Tools
 */

public class Statistics implements java.io.Serializable {

	// Fields

	private Integer pkStatistics;
	private String statisticsId;
	private String statisticalObjects;
	private Integer statisticalNumber;
	private Date statisticalTime;

	// Constructors

	/** default constructor */
	public Statistics() {
	}

	/** full constructor */
	public Statistics(String statisticsId, String statisticalObjects, Integer statisticalNumber, Date statisticalTime) {
		this.statisticsId = statisticsId;
		this.statisticalObjects = statisticalObjects;
		this.statisticalNumber = statisticalNumber;
		this.statisticalTime = statisticalTime;
	}

	// Property accessors

	public Integer getPkStatistics() {
		return this.pkStatistics;
	}

	public void setPkStatistics(Integer pkStatistics) {
		this.pkStatistics = pkStatistics;
	}

	public String getStatisticsId() {
		return this.statisticsId;
	}

	public void setStatisticsId(String statisticsId) {
		this.statisticsId = statisticsId;
	}

	public String getStatisticalObjects() {
		return this.statisticalObjects;
	}

	public void setStatisticalObjects(String statisticalObjects) {
		this.statisticalObjects = statisticalObjects;
	}

	public Integer getStatisticalNumber() {
		return this.statisticalNumber;
	}

	public void setStatisticalNumber(Integer statisticalNumber) {
		this.statisticalNumber = statisticalNumber;
	}

	public Date getStatisticalTime() {
		return this.statisticalTime;
	}

	public void setStatisticalTime(Date statisticalTime) {
		this.statisticalTime = statisticalTime;
	}

}