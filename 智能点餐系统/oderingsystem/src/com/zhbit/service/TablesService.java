package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Tables;

public interface TablesService {
	
public List <Tables> selectTables();
	
	public boolean addTable(Tables tables);
	
	public boolean deleteTable(String tablesId);
	
	public Tables selectTablesId(int pkTables);
	
	public boolean updateTable(Tables tables);

}
