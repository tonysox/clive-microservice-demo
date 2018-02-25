package com.clive.microservice.warehouse.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BatchDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long quantity;

	private LocalDate dateReceived;

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
