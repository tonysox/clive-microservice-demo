package com.clive.microservice.warehouse.web;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clive.microservice.warehouse.domain.Inventory;
import com.clive.microservice.warehouse.repository.InventoryRepository;
import com.clive.microservice.warehouse.service.dto.AddBatchDTO;
import com.clive.microservice.warehouse.service.dto.BatchDTO;
import com.clive.microservice.warehouse.service.dto.BatchDetailDTO;
import com.clive.microservice.warehouse.service.mapper.InventoryMapper;

@RestController
@RequestMapping("/api/inventories")
public class InventoryResource {

	private InventoryRepository inventoryRepository;

	private InventoryMapper inventoryMapper;

	public InventoryResource(InventoryRepository inventoryRepository, InventoryMapper inventoryMapper) {
		super();
		this.inventoryRepository = inventoryRepository;
		this.inventoryMapper = inventoryMapper;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void createInventory(@Valid @RequestBody AddBatchDTO productDTO) {

		Inventory product = inventoryMapper.toEntity(productDTO);

		inventoryRepository.save(product);

	}

	@PutMapping("/{batchId}")
	@ResponseStatus(HttpStatus.OK)
	public void updateInventory(@PathVariable String batchId, @Valid @RequestBody BatchDTO batchDTO) {

		Inventory product = inventoryMapper.toEntity(batchId, batchDTO);

		inventoryRepository.save(product);

	}

	@DeleteMapping("/{batchId}")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public void deleteInventory(@PathVariable String batchId) {

		inventoryRepository.delete(batchId);

	}

	@GetMapping("/{batchId}")
	@ResponseStatus(HttpStatus.OK)
	public BatchDetailDTO getInventory(@PathVariable String bacthId) {

		Inventory inventory = inventoryRepository.findOne(bacthId);

		return inventoryMapper.toDTO(inventory);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public Page<Inventory> getProducts(Pageable pageable) {

		return inventoryRepository.findAll(pageable);

	}

}
