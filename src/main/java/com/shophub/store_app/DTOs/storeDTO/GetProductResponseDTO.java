package com.shophub.store_app.DTOs.storeDTO;

import com.shophub.store_app.model.Product;
import lombok.Data;

@Data
public class GetProductResponseDTO {
    private ProductResponseDTO product;

    public static ProductResponseDTO convertToProductResponseDTO(Product product){
        return ProductResponseDTO.convertToProductResponseDTO(product);
    }
}
