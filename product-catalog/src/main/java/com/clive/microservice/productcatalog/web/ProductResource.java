package com.clive.microservice.productcatalog.web;

import java.util.UUID;

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

import com.clive.microservice.productcatalog.domain.Product;
import com.clive.microservice.productcatalog.repository.ProductRepository;
import com.clive.microservice.productcatalog.service.dto.ProductDTO;
import com.clive.microservice.productcatalog.service.dto.ProductIdDTO;
import com.clive.microservice.productcatalog.service.mapper.ProductMapper;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

	private ProductRepository productRepository;

	private ProductMapper productMapper;

	public ProductResource(ProductRepository productRepository, ProductMapper productMapper) {
		super();
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ProductIdDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
		ProductIdDTO productId = new ProductIdDTO(UUID.randomUUID());

		Product product = productMapper.toEntity(productDTO);

		product.setProductId(productId.getProductId().toString());

		productRepository.save(product);

		return productId;

	}

	@PutMapping("/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public void updateProduct(@PathVariable UUID productId, @Valid @RequestBody ProductDTO productDTO) {

		Product product = productMapper.toEntity(productDTO);

		product.setProductId(productId.toString());

		productRepository.save(product);

	}

	@DeleteMapping("/{productId}")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public void deleteProduct(@PathVariable UUID productId) {

		productRepository.delete(productId.toString());

	}

	@GetMapping("/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDTO getProduct(@PathVariable String productId) {

		Product product = productRepository.findOne(productId);

		return productMapper.toDTO(product);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public Page<Product> getProducts(Pageable pageable) {

		return productRepository.findAll(pageable);

	}

}
