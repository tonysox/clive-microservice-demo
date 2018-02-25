package com.clive.microservice.warehouse.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.clive.microservice.warehouse.domain.Inventory;

public interface InventoryRepository extends PagingAndSortingRepository<Inventory, String> {

}
