package com.shophub.store_app.DTOs.storeDTO;

import com.shophub.store_app.model.Category;
import com.shophub.store_app.model.Product;
import lombok.Data;

@Data
public class ProductRequestDTO {
    private Long id;
    private String name;
    private Double price;
    private  String description;
    private CategoryRequestDTO category;
    private String imageUrl;

    public static Product convertToProduct(ProductRequestDTO product) {
        Product newProduct=new Product();
        newProduct.setId(product.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());
        Category newCategory=new Category();
        newCategory.setName(product.getCategory().getName());
        newProduct.setCategory(newCategory);
        newProduct.setImageUrl(product.getImageUrl());
        return newProduct;
    }
}
