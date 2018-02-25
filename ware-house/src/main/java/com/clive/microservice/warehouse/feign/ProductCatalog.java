package com.clive.microservice.warehouse.feign;

import java.util.UUID;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clive.microservice.warehouse.service.dto.ProductDTO;

@FeignClient("product-catalog")
public interface ProductCatalog {

	@RequestMapping(method = RequestMethod.GET, value = "/api/products/{productId}")
	ProductDTO getProduct(@PathVariable("productId") UUID productId);

}
