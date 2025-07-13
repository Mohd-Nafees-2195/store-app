package com.shophub.store_app.model.user;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Mentor extends User{
    private Double rating;
    private Double salary;
}
