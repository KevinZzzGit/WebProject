package com.zhbit.model;

import java.sql.Timestamp;

/**
 * Queue entity. @author MyEclipse Persistence Tools
 */

public class Queue implements java.io.Serializable {

	// Fields

	private Integer pkQueue;
	private String queueId;
	private Timestamp queueTime;
	private String queueState;
	private String queueHao;
	private Integer queueNum;

	// Constructors

	/** default constructor */
	public Queue() {
	}

	/** minimal constructor */
	public Queue(String queueId, Timestamp queueTime, String queueState, String queueHao) {
		this.queueId = queueId;
		this.queueTime = queueTime;
		this.queueState = queueState;
		this.queueHao = queueHao;
	}

	/** full constructor */
	public Queue(String queueId, Timestamp queueTime, String queueState, String queueHao, Integer queueNum) {
		this.queueId = queueId;
		this.queueTime = queueTime;
		this.queueState = queueState;
		this.queueHao = queueHao;
		this.queueNum = queueNum;
	}

	// Property accessors

	public Integer getPkQueue() {
		return this.pkQueue;
	}

	public void setPkQueue(Integer pkQueue) {
		this.pkQueue = pkQueue;
	}

	public String getQueueId() {
		return this.queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

	public Timestamp getQueueTime() {
		return this.queueTime;
	}

	public void setQueueTime(Timestamp queueTime) {
		this.queueTime = queueTime;
	}

	public String getQueueState() {
		return this.queueState;
	}

	public void setQueueState(String queueState) {
		this.queueState = queueState;
	}

	public String getQueueHao() {
		return this.queueHao;
	}

	public void setQueueHao(String queueHao) {
		this.queueHao = queueHao;
	}

	public Integer getQueueNum() {
		return this.queueNum;
	}

	public void setQueueNum(Integer queueNum) {
		this.queueNum = queueNum;
	}

}