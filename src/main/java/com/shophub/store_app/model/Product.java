package com.shophub.store_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel {
    private String name;
    private double price;
    private  String description;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JsonManagedReference
    private Category category;
    private String imageUrl;
}
