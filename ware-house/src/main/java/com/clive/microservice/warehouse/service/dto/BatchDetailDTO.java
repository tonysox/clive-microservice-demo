package com.clive.microservice.warehouse.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BatchDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String product;

	private long quantity;

	private LocalDate dateReceived;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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
