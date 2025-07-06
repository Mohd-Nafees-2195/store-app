package com.shophub.store_app.DTOs.storeDTO;

import com.shophub.store_app.model.Category;
import com.shophub.store_app.model.Product;
import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private double price;
    private  String description;
    private CategoryResponseDTO category;
    private String imageUrl;
    private Long createdAt;
    private Long updatedAt;

    public static ProductResponseDTO convertToProductResponseDTO(Product product) {
        ProductResponseDTO responseDTO=new ProductResponseDTO();
        responseDTO.setId(product.getId());
        responseDTO.setName(product.getName());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setDescription(product.getDescription());

        CategoryResponseDTO newCategory=new CategoryResponseDTO();
        newCategory.setName(product.getCategory().getName());
        newCategory.setId(product.getCategory().getId());
        newCategory.setCreatedAt(product.getCategory().getCreatedAt());
        newCategory.setUpdatedAt(product.getCategory().getUpdatedAt());
        responseDTO.setCategory(newCategory);

        responseDTO.setImageUrl(product.getImageUrl());
        responseDTO.setCreatedAt(product.getCreatedAt());
        responseDTO.setUpdatedAt(product.getUpdatedAt());
        return responseDTO;
    }
}
