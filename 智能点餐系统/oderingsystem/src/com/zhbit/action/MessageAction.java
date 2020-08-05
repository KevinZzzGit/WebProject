package com.zhbit.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.service.MessageService;
import com.zhbit.model.Customer;
import com.zhbit.model.Message;;
public class MessageAction extends ActionSupport {
	@Resource
	private MessageService messageService;
	private Integer pkMessage;
	private Customer customer;
	private String messageId;
	private Timestamp leaveTime;
	private String words;
	private Message message=new Message();
		
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public void setPkMessage(Integer pkMessage) {
		this.pkMessage = pkMessage;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}
	public void setWords(String words) {
		this.words = words;
	}

	
	public String findAllMessage(){
		List<Message> list=messageService.findAllStatiscis();
		ActionContext.getContext().getSession().put("messageList", list);
		return "findAllMessage";
	}
	public String postMessage() throws UnsupportedEncodingException{
		customer=(Customer)ActionContext.getContext().getSession().get("Customer");
		
		if(customer==null){
			ActionContext.getContext().getSession().put("errormsg","未登录，请登陆后操作！");
			return "error";
		}
		if(words==null){
			ActionContext.getContext().getSession().put("errormsg","不能提交空值~");
			return "error";
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		words = new String(words.getBytes("ISO-8859-1"),"utf-8");	
		
		message.setWords(words);
		message.setCustomer(customer);
		messageService.postMessage(message);
		
		
		
		return "postMessage";		
	}
	
}
