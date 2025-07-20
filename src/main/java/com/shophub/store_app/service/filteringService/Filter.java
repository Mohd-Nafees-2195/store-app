package com.shophub.store_app.service.filteringService;

import com.shophub.store_app.model.Product;

import java.util.List;

public interface Filter {
    List<Product> apply(List<Product> products,List<String> allowedValues);
}
