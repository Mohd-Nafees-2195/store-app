package com.shophub.store_app.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String productNotFound) {
        super(productNotFound);
    }
}
