package com.zhbit.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.MessageDao;
import com.zhbit.model.Customer;
import com.zhbit.model.Message;
import com.zhbit.service.MessageService;
@Transactional
public class MessageServiceImpl implements MessageService {
	@Resource
	MessageDao messageDao;
	
	public List<Message> findAllStatiscis(){
		return messageDao.findAllStatiscis();
	};
	public void postMessage(Message message){		
		messageDao.postMessage( message);
	};
}
