package com.shophub.store_app.DTOs.storeDTO;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private double price;
    private  String description;
    private String category;
    private String imageUrl;
}
