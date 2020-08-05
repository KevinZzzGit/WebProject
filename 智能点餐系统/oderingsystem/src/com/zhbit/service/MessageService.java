package com.zhbit.service;

import java.util.List;


import com.zhbit.model.Message;

public interface MessageService {
	
	public List<Message> findAllStatiscis();
	public void postMessage(Message message);
	
}
