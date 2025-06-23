package com.shophub.store_app.model;

import lombok.Data;

@Data
public class Product {
    private String productName;
    private double price;
    private  String description;
    private String category;
    private String imageUrl;
}
