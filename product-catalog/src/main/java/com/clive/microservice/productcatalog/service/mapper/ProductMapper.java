package com.clive.microservice.productcatalog.service.mapper;

import org.mapstruct.Mapper;

import com.clive.microservice.productcatalog.domain.Product;
import com.clive.microservice.productcatalog.service.dto.ProductDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper {

	// @Mapping(source = "ward.id", target = "wardId")
	Product toEntity(ProductDTO product);

	ProductDTO toDTO(Product product);

}
