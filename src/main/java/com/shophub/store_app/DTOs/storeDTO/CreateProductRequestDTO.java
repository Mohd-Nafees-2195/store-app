package com.shophub.store_app.DTOs.storeDTO;

import com.shophub.store_app.model.Product;
import lombok.Data;

@Data
public class CreateProductRequestDTO {
    private ProductRequestDTO product;

    public static Product convertToProduct(ProductRequestDTO product){
        return ProductRequestDTO.convertToProduct(product);
    }
}
