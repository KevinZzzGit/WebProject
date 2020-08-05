package com.zhbit.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.QueueDao;
import com.zhbit.model.Queue;
import com.zhbit.model.Tables;
import com.zhbit.service.QueueService;

@Transactional(propagation = Propagation.REQUIRED)
public class QueueServiceImpl implements QueueService {
	@Resource
	QueueDao queueDao;

	@Override
	public List<Queue> selectQueue1() {
		// TODO Auto-generated method stub
		List <Queue> queues = queueDao.selectQueue1();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueue2() {
		// TODO Auto-generated method stub
		List <Queue> queues = queueDao.selectQueue2();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueue3() {
		// TODO Auto-generated method stub
		List <Queue> queues = queueDao.selectQueue3();
		return queues;
	}

	
	public boolean addQueue(Queue queue) {
		// TODO Auto-generated method stub
		return queueDao.addQueue(queue);
	}

	
	public boolean updateState(String queueState,String queueId,int queueNum) {
		// TODO Auto-generated method stub
		return queueDao.updateState(queueState,queueId,queueNum);
	}
	
	@Override
	public List <Tables> selectTableState1(){
		List <Tables> tables = queueDao.selectTableState1();
		return tables;
	}
	
	@Override
	public List <Tables> selectTableState2(){
		List <Tables> tables = queueDao.selectTableState2();
		return tables;
	}
	
	@Override
	public List <Tables> selectTableState3(){
		List <Tables> tables = queueDao.selectTableState3();
		return tables;
	}
	
	@Override
	public List<Queue> selectQueueState1(){
		List <Queue> queues = queueDao.selectQueueState1();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueueState2(){
		List <Queue> queues = queueDao.selectQueueState2();
		return queues;
	}
	
	@Override
	public List<Queue> selectQueueState3(){
		List <Queue> queues = queueDao.selectQueueState3();
		return queues;
	}

}
