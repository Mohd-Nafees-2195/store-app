package com.shophub.store_app.model.user;


import com.shophub.store_app.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseModel {
    private String name;
    private String email;
}
