package com.clive.microservice.productcatalog.service.dto;

import java.io.Serializable;
import java.util.UUID;

public class ProductIdDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UUID productId;

	public UUID getProductId() {
		return productId;
	}

	public ProductIdDTO(UUID productId) {
		super();
		this.productId = productId;
	}

}
