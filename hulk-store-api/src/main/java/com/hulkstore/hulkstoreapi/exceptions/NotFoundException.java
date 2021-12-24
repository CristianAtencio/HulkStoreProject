package com.hulkstore.hulkstoreapi.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.hulkstore.hulkstoreapi.dtos.ErrorDto;

public class NotFoundException extends HulkStoreException{

	private static final long serialVersionUID = 1L;

	public NotFoundException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}

	public NotFoundException(String code, String message, ErrorDto data) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}

}
