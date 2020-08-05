package com.zhbit.dao;

import java.util.List;


import com.zhbit.model.Message;

public interface MessageDao {
	public List<Message> findAllStatiscis();
	public void postMessage(Message message);
}
