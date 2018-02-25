package com.clive.microservice.warehouse.service.mapper;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.clive.microservice.warehouse.domain.Inventory;
import com.clive.microservice.warehouse.feign.ProductCatalog;
import com.clive.microservice.warehouse.repository.InventoryRepository;
import com.clive.microservice.warehouse.service.dto.AddBatchDTO;
import com.clive.microservice.warehouse.service.dto.BatchDTO;
import com.clive.microservice.warehouse.service.dto.BatchDetailDTO;
import com.clive.microservice.warehouse.service.dto.ProductDTO;

@Mapper(componentModel = "spring", uses = {})
public abstract class InventoryMapper {

	@Autowired
	ProductCatalog productCatalog;

	@Autowired
	private InventoryRepository inventoryRepository;

	public Inventory toEntity(AddBatchDTO batch) {
		Inventory inventory = new Inventory();

		ProductDTO product = productCatalog.getProduct(batch.getProductId());

		inventory.setBatchId(batch.getBatchId());
		inventory.setDateReceived(batch.getDateReceived());
		inventory.setProduct(product.getProductName());
		inventory.setQuantity(batch.getQuantity());

		return inventory;

	}

	public Inventory toEntity(String batchId, BatchDTO batch) {

		Inventory inventory = inventoryRepository.findOne(batchId);

		inventory.setDateReceived(batch.getDateReceived());
		inventory.setQuantity(batch.getQuantity());

		return inventory;

	}

	public abstract BatchDetailDTO toDTO(Inventory inventory) ;

}
