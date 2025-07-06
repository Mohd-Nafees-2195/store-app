package com.shophub.store_app.DTOs.storeDTO;

import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private Long createdAt;
    private Long updatedAt;
}
