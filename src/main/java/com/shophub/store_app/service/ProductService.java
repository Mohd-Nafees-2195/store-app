package com.shophub.store_app.service;

import com.shophub.store_app.DTOs.storeDTO.ProductRequestDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTOs;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
    ProductResponseDTOs getAllProduct();
    ProductResponseDTO getProduct(Long productId);
    ProductResponseDTO updateProduct(Long productId,ProductRequestDTO requestDTO);
    void deleteProduct(Long productId);
}
