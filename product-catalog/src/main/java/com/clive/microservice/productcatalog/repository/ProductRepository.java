package com.clive.microservice.productcatalog.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.clive.microservice.productcatalog.domain.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

}
