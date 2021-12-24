package com.hulkstore.hulkstoreapi.services;

import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.jsons.ProductUpdateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductCreateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductRest;

public interface ProductService {

	ProductRest getProductByid(Long productId) throws HulkStoreException;
	
	String createProduct(ProductCreateRest productRest) throws HulkStoreException;
	
	String updateProduct(ProductUpdateRest productRest) throws HulkStoreException;
}
