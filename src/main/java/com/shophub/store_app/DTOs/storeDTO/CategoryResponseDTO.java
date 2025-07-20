package com.shophub.store_app.DTOs.storeDTO;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
