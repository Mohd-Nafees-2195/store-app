package com.shophub.store_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;
import java.util.List;

@Data
@Entity
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> specialProducts;

}
