package com.zhbit.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zhbit.dao.TablesDao;
import com.zhbit.model.Tables;

public class TablesDaoImpl implements TablesDao {
	@Resource
	private SessionFactory sessions;

	@Override
	public List<Tables> selectTables() {
		// TODO Auto-generated method stub
		Session sess = sessions.getCurrentSession();
	    List <Tables> tables = new ArrayList<Tables>();
	    tables = sess.createQuery("from Tables t order by t.tablesId").list();
		return tables;
	}

	@Override
	public boolean addTable(Tables tables) {
		// TODO Auto-generated method stub
		int count;
		String tablesId = "";
		Session sess = sessions.getCurrentSession();
		if(tables.getSeatNumber()<3){
		    List <Tables> tablesA = new ArrayList<Tables>();
		    tablesA = sess.createQuery("from Tables t where t.seatNumber < 3").list();
		    count = tablesA.size()+1;
		    tablesId = "A"+count;
		    if(tablesId.length()<3){
		    	tablesId = "A"+0+count;
		    }
		}else if(tables.getSeatNumber()<5 && tables.getSeatNumber()>2){
			List <Tables> tablesB = new ArrayList<Tables>();
		    tablesB = sess.createQuery("from Tables t where t.seatNumber < 5 and t.seatNumber > 2").list();
		    count = tablesB.size()+1;
		    tablesId = "B"+count;
		    if(tablesId.length()<3){
		    	tablesId = "B"+0+count;
		    }
		}else if(tables.getSeatNumber()>4){
			List <Tables> tablesC = new ArrayList<Tables>();
		    tablesC = sess.createQuery("from Tables t where t.seatNumber > 4").list();
		    count = tablesC.size()+1;
		    tablesId = "C"+count;
		    if(tablesId.length()<3){
		    	tablesId = "C"+0+count;
		    }
		}
		Tables t = new Tables();
		t.setTablesId(tablesId);
		t.setSeatNumber(tables.getSeatNumber());
		t.setTableState(tables.getTableState());
		t.setOrderState(tables.getOrderState());
		sess.save(t);
		return true;
	}

	@Override
	public boolean deleteTable(String tablesId) {
		// TODO Auto-generated method stub
		Session sess = sessions.getCurrentSession();
		Query q1 = sess.createQuery("delete from Tables t where t.tablesId = '"+tablesId+"'");
		q1.executeUpdate();
		return true;
	}

	@Override
	public Tables selectTablesId(int pkTables) {
		// TODO Auto-generated method stub
		Session sess = sessions.getCurrentSession();
		List <Tables> tables = new ArrayList<Tables>();
		tables = sess.createQuery("from Tables t where t.pkTables = '"+pkTables+"'").list();
		Tables table = new Tables();
		Iterator itr = tables.iterator();
		while(itr.hasNext()){
			Tables t = (Tables) itr.next();
			table.setPkTables(t.getPkTables());
			table.setTablesId(t.getTablesId());
			table.setSeatNumber(t.getSeatNumber());
			table.setTableState(t.getTableState());
			table.setOrderState(t.getOrderState());
		}
		return table;
	}

	@Override
	public boolean updateTable(Tables tables) {
		// TODO Auto-generated method stub
		Session sess = sessions.getCurrentSession();
		Query q2 = sess.createQuery("update Tables t set t.tablesId = '"+tables.getTablesId()+"'"
				+ ",t.seatNumber = '"+tables.getSeatNumber()+"'"
				+ ",t.tableState = '"+tables.getTableState()+"',t.orderState = '"+tables.getOrderState()+"'"
						+ " where t.pkTables = '"+tables.getPkTables()+"'");
		System.out.println(q2);
		q2.executeUpdate();
		return true;
	}

}
