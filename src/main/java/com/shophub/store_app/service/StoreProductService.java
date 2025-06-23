package com.shophub.store_app.service;

import com.shophub.store_app.DTOs.storeDTO.ProductRequestDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTOs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StoreProductService")
public class StoreProductService implements ProductService{
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        return null;
    }

    @Override
    public ProductResponseDTOs getAllProduct() {
        return null;
    }

    @Override
    public ProductResponseDTO getProduct(Long productId) {
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(Long productId,ProductRequestDTO requestDTO) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
