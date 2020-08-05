package com.zhbit.daoimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.validator.constraints.Length;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.dao.QueueDao;
import com.zhbit.model.Queue;
import com.zhbit.model.Tables;

public class QueueDaoImpl implements QueueDao {
	@Resource
	private SessionFactory sessions;
	
	@Override
	public List<Queue> selectQueue1() {
		// TODO Auto-generated method stub
		String time;
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}
		System.out.println(time);
		Session sess = sessions.getCurrentSession();
	    List <Queue> queues = new ArrayList<Queue>();
	    queues = sess.createQuery("from Queue q where q.queueNum < 3 and convert(varchar(10),q.queueTime,121) = '"+time+"'").list();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueue2() {
		// TODO Auto-generated method stub
		String time;
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}
		System.out.println(time);
		Session sess = sessions.getCurrentSession();
	    List <Queue> queues = new ArrayList<Queue>();
	    queues = sess.createQuery("from Queue q where q.queueNum < 5 and q.queueNum > 2 and convert(varchar(10),q.queueTime,121) = '"+time+"'").list();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueue3() {
		// TODO Auto-generated method stub
		String time;
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}
		System.out.println(time);
		Session sess = sessions.getCurrentSession();
	    List <Queue> queues = new ArrayList<Queue>();
	    queues = sess.createQuery("from Queue q where q.queueNum > 4 and convert(varchar(10),q.queueTime,121) = '"+time+"'").list();
		return queues;
	}

	@Override
	public boolean addQueue(Queue queue) {
		// TODO Auto-generated method stub
		int count;
		int countID;
		String time;
		String queueHao = "";
		String queueId = "";
		//获取系统时间
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}
		System.out.println(time);
		Session sess = sessions.getCurrentSession();
		//生成queueId
		List <Queue> queueID = new ArrayList<Queue>();
		queueID = sess.createQuery("from Queue").list();
		countID = queueID.size()+1;
		String countIDD = countID+"";
		if(4-countIDD.length()==3){
			queueId = "000"+countID;
		}else if(4-countIDD.length()==2){
			queueId = "00"+countID;
		}else if(4-countIDD.length()==1){
			queueId = "0"+countID;
		}else{
			queueId = countID+"";
		}
		//生成queueHao
		if(queue.getQueueNum()<=2){
			List <Queue> queueA = new ArrayList<Queue>();
			queueA = sess.createQuery("from Queue q where convert(varchar(10),q.queueTime,121) = '"+time+"'"
					+ "and q.queueNum<3").list();
			count = queueA.size()+1;
			queueHao = "A"+count;
			if(queueHao.length()<3){
				queueHao = "A"+0+count;
			}
		}else if(queue.getQueueNum()<=4&&queue.getQueueNum()>2){
			List <Queue> queueB = new ArrayList<Queue>();
			queueB = sess.createQuery("from Queue q where convert(varchar(10),q.queueTime,121) = '"+time+"'"
					+ "and q.queueNum<5 and q.queueNum>2").list();
			count = queueB.size()+1;
			queueHao = "B"+count;
			if(queueHao.length()<3){
				queueHao = "B"+0+count;
			}
		}else if(queue.getQueueNum()>4){
			List <Queue> queueC = new ArrayList<Queue>();
			queueC = sess.createQuery("from Queue q where convert(varchar(10),q.queueTime,121) = '"+time+"'"
					+ "and q.queueNum>4").list();
			count = queueC.size()+1;
			queueHao = "C"+count;
			if(queueHao.length()<3){
				queueHao = "C"+0+count;
			}
		}
		Queue q = new Queue();
		q.setQueueId(queueId);
		q.setQueueTime(queue.getQueueTime());
		q.setQueueState(queue.getQueueState());
		q.setQueueNum(queue.getQueueNum());
		q.setQueueHao(queueHao);
		sess.save(q);
		queue.setQueueHao(queueHao);
		return true;
	}

	@Override
	public boolean updateState(String queueState,String queueId,int queueNum) {
		// TODO Auto-generated method stub
		String tablesId;
		Session sess = sessions.getCurrentSession();
		if(queueState.equals("过号")){
			Query q1 = sess.createQuery("update Queue q set q.queueState = '过号' where q.queueId = '"+queueId+"'");
			q1.executeUpdate();
		}else if(queueState.equals("入座")){
			Query q2 = sess.createQuery("update Queue q set q.queueState = '入座' where q.queueId = '"+queueId+"'");
			q2.executeUpdate();
			if(queueNum < 3){
				List <Tables> tables = new ArrayList<Tables>();
			    tables = sess.createQuery("from Tables t where t.seatNumber < 3 and t.tableState = 0").list();
			    Tables t = (Tables) tables.get(0);
			    tablesId = t.getTablesId();
			    System.out.println(tablesId);
			    Query q3 = sess.createQuery("update Tables t set t.tableState = 'true' where t.tablesId = '"+tablesId+"'");
				q3.executeUpdate();
				ActionContext.getContext().getSession().put("tablesId", tablesId);
			}else if(queueNum < 5 && queueNum > 2){
				List <Tables> tables = new ArrayList<Tables>();
			    tables = sess.createQuery("from Tables t where t.seatNumber < 5 and t.seatNumber > 2 and t.tableState = 0").list();
			    Tables t = (Tables) tables.get(0);
			    tablesId = t.getTablesId();
			    System.out.println(tablesId);
			    Query q3 = sess.createQuery("update Tables t set t.tableState = 'true' where t.tablesId = '"+tablesId+"'");
				q3.executeUpdate();
				ActionContext.getContext().getSession().put("tablesId", tablesId);
			}else if(queueNum > 4){
				List <Tables> tables = new ArrayList<Tables>();
			    tables = sess.createQuery("from Tables t where t.seatNumber > 4 and t.tableState = 0").list();
			    Tables t = (Tables) tables.get(0);
			    tablesId = t.getTablesId();
			    System.out.println(tablesId);
			    Query q3 = sess.createQuery("update Tables t set t.tableState = 'true' where t.tablesId = '"+tablesId+"'");
				q3.executeUpdate();
				ActionContext.getContext().getSession().put("tablesId", tablesId);
			}
		}
		return true;
	}
	
	@Override
	public List <Tables> selectTableState1(){
		Session sess = sessions.getCurrentSession();
	    List <Tables> tables = new ArrayList<Tables>();
	    tables = sess.createQuery("from Tables t where t.seatNumber < 3 and t.tableState = 0").list();
		return tables;
	}
	
	@Override
	public List <Tables> selectTableState2(){
		Session sess = sessions.getCurrentSession();
	    List <Tables> tables = new ArrayList<Tables>();
	    tables = sess.createQuery("from Tables t where t.seatNumber < 5 and t.seatNumber > 2 and t.tableState = 0").list();
		return tables;
	}
	
	@Override
	public List <Tables> selectTableState3(){
		Session sess = sessions.getCurrentSession();
	    List <Tables> tables = new ArrayList<Tables>();
	    tables = sess.createQuery("from Tables t where t.seatNumber > 4 and t.tableState = 0").list();
		return tables;
	}
	
	
	@Override
	public List<Queue> selectQueueState1() {
		// TODO Auto-generated method stub
		String time;
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}
		System.out.println(time);
		Session sess = sessions.getCurrentSession();
	    List <Queue> queues = new ArrayList<Queue>();
	    queues = sess.createQuery("from Queue q where q.queueNum < 3 and convert(varchar(10),q.queueTime,121) = '"+time+"' and q.queueState = '等待'").list();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueueState2() {
		// TODO Auto-generated method stub
		String time;
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}
		System.out.println(time);
		Session sess = sessions.getCurrentSession();
	    List <Queue> queues = new ArrayList<Queue>();
	    queues = sess.createQuery("from Queue q where q.queueNum < 5 and q.queueNum > 2 and convert(varchar(10),q.queueTime,121) = '"+time+"' and q.queueState = '等待'").list();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueueState3() {
		// TODO Auto-generated method stub
		String time;
		Calendar calendar = Calendar.getInstance();
		int m = calendar.get(Calendar.MONTH)+1;
		String mm = m+"";
		if(mm.length()==1){
			mm = "0"+m;
		}
		time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+calendar.get(Calendar.DATE);
		if(time.length()<10){
			time = calendar.get(Calendar.YEAR)+"-"+mm+"-"+0+calendar.get(Calendar.DATE);
		}
		
		Session sess = sessions.getCurrentSession();
	    List <Queue> queues = new ArrayList<Queue>();
	    queues = sess.createQuery("from Queue q where q.queueNum > 4 and convert(varchar(10),q.queueTime,121) = '"+time+"' and q.queueState = '等待'").list();
		return queues;
	}

}
