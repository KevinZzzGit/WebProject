package com.zhbit.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.TablesDao;
import com.zhbit.model.Tables;
import com.zhbit.service.TablesService;

@Transactional(propagation = Propagation.REQUIRED)
public class TablesServiceImpl implements TablesService {
	@Resource
	TablesDao tablesDao;

	@Override
	public List<Tables> selectTables() {
		// TODO Auto-generated method stub
		List <Tables> tables = tablesDao.selectTables();
		return tables;
	}

	@Override
	public boolean addTable(Tables tables) {
		// TODO Auto-generated method stub
		
		return tablesDao.addTable(tables);
	}

	@Override
	public boolean deleteTable(String tablesId) {
		// TODO Auto-generated method stub
		return tablesDao.deleteTable(tablesId);
	}

	@Override
	public Tables selectTablesId(int pkTables) {
		// TODO Auto-generated method stub
		Tables table = tablesDao.selectTablesId(pkTables);
		return table;
	}

	@Override
	public boolean updateTable(Tables tables) {
		// TODO Auto-generated method stub
		return tablesDao.updateTable(tables);
	}

}
