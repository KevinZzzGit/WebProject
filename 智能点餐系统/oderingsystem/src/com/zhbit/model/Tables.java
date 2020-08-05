package com.zhbit.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Tables entity. @author MyEclipse Persistence Tools
 */

public class Tables implements java.io.Serializable {

	// Fields

	private Integer pkTables;
	private String tablesId;
	private Integer seatNumber;
	private Boolean tableState;
	private Boolean orderState;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tables() {
	}

	/** minimal constructor */
	public Tables(String tablesId, Integer seatNumber, Boolean tableState, Boolean orderState) {
		this.tablesId = tablesId;
		this.seatNumber = seatNumber;
		this.tableState = tableState;
		this.orderState = orderState;
	}

	/** full constructor */
	public Tables(String tablesId, Integer seatNumber, Boolean tableState, Boolean orderState, Set orders) {
		this.tablesId = tablesId;
		this.seatNumber = seatNumber;
		this.tableState = tableState;
		this.orderState = orderState;
		this.orders = orders;
	}

	// Property accessors

	public Integer getPkTables() {
		return this.pkTables;
	}

	public void setPkTables(Integer pkTables) {
		this.pkTables = pkTables;
	}

	public String getTablesId() {
		return this.tablesId;
	}

	public void setTablesId(String tablesId) {
		this.tablesId = tablesId;
	}

	public Integer getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Boolean getTableState() {
		return this.tableState;
	}

	public void setTableState(Boolean tableState) {
		this.tableState = tableState;
	}

	public Boolean getOrderState() {
		return this.orderState;
	}

	public void setOrderState(Boolean orderState) {
		this.orderState = orderState;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}