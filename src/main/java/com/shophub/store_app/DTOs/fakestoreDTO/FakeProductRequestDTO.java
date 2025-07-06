package com.shophub.store_app.DTOs.fakestoreDTO;

import com.shophub.store_app.DTOs.storeDTO.ProductRequestDTO;
import lombok.Data;

@Data
public class FakeProductRequestDTO {
    private String title;
    private double price;
    private  String description;
    private String category;
    private String image;

    public void copy(ProductRequestDTO requestDTO) {
        this.title=requestDTO.getName();
        this.price= requestDTO.getPrice();
        this.description=requestDTO.getDescription();
        this.category= requestDTO.getCategory().getName();
        this.image=requestDTO.getImageUrl();
    }
}
