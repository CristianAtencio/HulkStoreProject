package com.hulkstore.hulkstoreapi.services;

import com.hulkstore.hulkstoreapi.dtos.MovementActionDTO;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.jsons.ProductUpdateRest;
import com.hulkstore.hulkstoreapi.jsons.CompleteProductRest;
import com.hulkstore.hulkstoreapi.jsons.ProductCreateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductRest;

public interface ProductService {

	ProductRest getProductByid(Long productId) throws HulkStoreException;
	
	CompleteProductRest getCompleteProductByid(Long productId) throws HulkStoreException;
	
	String createProduct(ProductCreateRest productRest) throws HulkStoreException;
	
	String updateProduct(Long productId, ProductUpdateRest productRest) throws HulkStoreException;
	
	void updateProductByMovement(MovementActionDTO movementActionDTO) throws HulkStoreException;
}
