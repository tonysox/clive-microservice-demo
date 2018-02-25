package com.clive.microservice.warehouse.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class AddBatchDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String batchId;

	private UUID productId;

	private long quantity;

	private LocalDate dateReceived;

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
	}

}
