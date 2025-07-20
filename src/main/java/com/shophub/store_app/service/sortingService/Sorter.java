package com.shophub.store_app.service.sortingService;

import com.shophub.store_app.model.Product;

import java.util.List;

public interface Sorter {
    List<Product> sort(List<Product> products);
}
