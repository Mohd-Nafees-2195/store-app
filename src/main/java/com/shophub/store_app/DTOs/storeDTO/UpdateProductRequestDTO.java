package com.shophub.store_app.DTOs.storeDTO;

import com.shophub.store_app.model.Product;
import lombok.Data;

@Data
public class UpdateProductRequestDTO {
    private ProductRequestDTO product;

    public static Product convertToProduct(ProductRequestDTO request){
        return ProductRequestDTO.convertToProduct(request);
    }
}
