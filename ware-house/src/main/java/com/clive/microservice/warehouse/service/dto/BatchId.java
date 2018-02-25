package com.clive.microservice.warehouse.service.dto;

import java.io.Serializable;

public class BatchId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String batchId;

	public String getBatchId() {
		return batchId;
	}

	public BatchId(String batchId) {
		super();
		this.batchId = batchId;
	}

}
