package com.shophub.store_app.service.filteringService;

import com.shophub.store_app.model.Product;

import java.util.List;

public class BrandFilter implements Filter{
    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        return List.of();
    }
}
