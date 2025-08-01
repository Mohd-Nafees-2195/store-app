package com.shophub.store_app.DTOs.storeDTO;

import com.shophub.store_app.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDTOs {
    private List<ProductResponseDTO> products;

    public static ProductResponseDTO convertToProductResponseDTO(Product product){
        return ProductResponseDTO.convertToProductResponseDTO(product);
    }
}
