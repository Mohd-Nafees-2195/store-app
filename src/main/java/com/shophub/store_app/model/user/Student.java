package com.shophub.store_app.model.user;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Student extends User {
    private Double cgpa;
    private Integer psp;
    private Integer rank;
}
