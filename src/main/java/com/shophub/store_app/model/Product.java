package com.shophub.store_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel {
    private String name;
    private double price;
    private  String description;

    @ManyToOne
    @JsonManagedReference
    private Category category;
    private String imageUrl;
}
