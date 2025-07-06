package com.shophub.store_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;

    @OneToMany
    private List<Product> specialProducts;

}
