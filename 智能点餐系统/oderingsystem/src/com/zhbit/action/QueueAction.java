package com.zhbit.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.zhbit.model.Queue;
import com.zhbit.model.Tables;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.service.QueueService;

public class QueueAction extends ActionSupport {
	private Queue queue;
	@Resource
	private QueueService queueService;

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	
    public String queueList(){
    	List <Queue> queues1 = queueService.selectQueue1();
    	List <Queue> queues2 = queueService.selectQueue2();
    	List <Queue> queues3 = queueService.selectQueue3();
    	List <Tables> tables1 = queueService.selectTableState1();
    	List <Tables> tables2 = queueService.selectTableState2();
    	List <Tables> tables3 = queueService.selectTableState3();
    	HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("queues1", queues1);
		request.setAttribute("queues2", queues2);
		request.setAttribute("queues3", queues3);
		request.setAttribute("tables1", tables1.size());
		request.setAttribute("tables2", tables2.size());
		request.setAttribute("tables3", tables3.size());
		return SUCCESS;
    }
    
    public String addQueue(){
    	queueService.addQueue(queue);
    	return SUCCESS;
    }
    
    public String updateStateG(){
    	queueService.updateState("过号", queue.getQueueId(),queue.getQueueNum());
    	return SUCCESS;
    }
    
    public String updateStateR(){
    	queueService.updateState("入座", queue.getQueueId(),queue.getQueueNum());
    	return SUCCESS;
    }
    
    public String getTime(){
    	Calendar calendar = Calendar.getInstance();
    	ActionContext.getContext().getSession().put("queueTime", calendar.getTime());
    	return SUCCESS;
    }
    
    public String toQueue(){
    	String tablesId="";
    	ActionContext.getContext().getSession().put("tablesId",tablesId);
    	return SUCCESS;
    }
    
    public String customerAddQueue(){
    	String queueHM = "";
    	List <Queue> queues = new ArrayList<Queue>();
    	queueService.addQueue(queue);
    	if(queue.getQueueNum()<3){
    		queueHM = "小桌"+queue.getQueueHao();
    		queues = queueService.selectQueueState1();
    	}else if(queue.getQueueNum()<5&&queue.getQueueNum()>2){
    		queueHM = "中桌"+queue.getQueueHao();
    		queues = queueService.selectQueueState2();
    	}else if(queue.getQueueNum()>4){
    		queueHM = "大桌"+queue.getQueueHao();
    		queues = queueService.selectQueueState3();
    	}
    	ActionContext.getContext().getSession().put("queueHM", queueHM);
    	ActionContext.getContext().getSession().put("queues", queues.size()-1);
    	return SUCCESS;
    }
    
    public String toCustomerQueue(){
    	return SUCCESS;
    }
}
