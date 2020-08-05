package com.zhbit.service;

import java.util.List;

import com.zhbit.model.Queue;
import com.zhbit.model.Tables;

public interface QueueService {
      
    public List <Queue> selectQueue1();
    
    public List <Queue> selectQueue2();
    
    public List <Queue> selectQueue3();
	
	public boolean addQueue(Queue queue);
	
	public boolean updateState(String queueState,String queueId,int queueNum);
	
	public List <Tables> selectTableState1();
	
	public List <Tables> selectTableState2();
	
	public List <Tables> selectTableState3();
	
	public List<Queue> selectQueueState1();
	
	public List<Queue> selectQueueState2();
	
	public List<Queue> selectQueueState3();
}
