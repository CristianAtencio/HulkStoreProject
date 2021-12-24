package com.hulkstore.hulkstoreapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.jsons.ProductUpdateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductCreateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductRest;
import com.hulkstore.hulkstoreapi.responses.HulkStoreResponse;
import com.hulkstore.hulkstoreapi.services.ProductService;

@RestController
@RequestMapping(path = "/hulk-store" + "/v1")
public class ProductController {

	@Autowired
	ProductService productService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "product" + "/{" + "productId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HulkStoreResponse<ProductRest> getProductById(@PathVariable Long productId) throws HulkStoreException {
		return new HulkStoreResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				productService.getProductByid(productId));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "product/complete" + "/{" + "productId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HulkStoreResponse<ProductRest> getCompleteProductById(@PathVariable Long productId)
			throws HulkStoreException {
		return new HulkStoreResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				productService.getProductByid(productId));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HulkStoreResponse<String> createProduct(@Validated @RequestBody ProductCreateRest productRest) throws HulkStoreException{
		return new HulkStoreResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				productService.createProduct(productRest));
	}
	
}
