package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.zhbit.model.Tables;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.service.TablesService;

public class TablesAction extends ActionSupport{
	private Tables tables;
	private Integer pkTables;
	private String tablesId;
	private Integer seatNumber;
	private Boolean tableState;
	private Boolean orderState;
	
	
	public void setPkTables(Integer pkTables) {
		this.pkTables = pkTables;
	}
	public void setTablesId(String tablesId) {
		this.tablesId = tablesId;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public void setTableState(Boolean tableState) {
		this.tableState = tableState;
	}
	public void setOrderState(Boolean orderState) {
		this.orderState = orderState;
	}
	public void setTablesService(TablesService tablesService) {
		this.tablesService = tablesService;
	}

	@Resource
	private TablesService tablesService;
	
	public Tables getTables() {
		return tables;
	}
	public void setTables(Tables tables) {
		this.tables = tables;
	}
	
	public String tablesList(){
		List <Tables> tables = tablesService.selectTables();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("tables", tables);
		return SUCCESS;
	}
	
	public String addTable(){
		tablesService.addTable(tables);
		return SUCCESS;
	}
    
	public String deleteTable(){
		tablesService.deleteTable(tables.getTablesId());
		return SUCCESS;
	}
	
	public String selectTablesId(){
		Tables tablesId = tablesService.selectTablesId(tables.getPkTables());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("tablesId", tablesId);
		return SUCCESS;
	}
	
	public String updateTable(){
		tablesService.updateTable(tables);
		return SUCCESS;
	}
	
	public String toTables(){
		return SUCCESS;
	}
	public String waiterToTables(){
		List <Tables> tables = tablesService.selectTables();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("tables", tables);
		return SUCCESS;
		
	}  
	
	public String setTables(){
		Tables tabless=new Tables();
		tabless.setPkTables(pkTables);
		tabless.setTablesId(tablesId);
		tabless.setSeatNumber(seatNumber);
		tabless.setOrderState(orderState);
		tabless.setTableState(tableState);
		ActionContext.getContext().getSession().put("tabless",tabless);
		return "setTables";
	}

	
}
