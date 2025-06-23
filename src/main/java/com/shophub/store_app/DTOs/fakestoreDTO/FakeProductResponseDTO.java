package com.shophub.store_app.DTOs.fakestoreDTO;

import com.shophub.store_app.DTOs.storeDTO.ProductRequestDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTO;
import lombok.Data;

@Data
public class FakeProductResponseDTO {
    private Long id;
    private String title;
    private double price;
    private  String description;
    private String category;
    private String image;

    public ProductResponseDTO copy(ProductResponseDTO responseDTO) {
        responseDTO.setProductName(this.getTitle());
        responseDTO.setProductId(this.getId());
        responseDTO.setPrice(this.getPrice());
        responseDTO.setDescription(this.getDescription());
        responseDTO.setCategory(this.getCategory());
        responseDTO.setImageUrl(this.getImage());
        return responseDTO;
    }
}
