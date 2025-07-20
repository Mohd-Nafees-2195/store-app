package com.shophub.store_app.service;

import com.shophub.store_app.DTOs.storeDTO.*;
import com.shophub.store_app.exception.InvalidRequestException;
import com.shophub.store_app.model.Category;
import com.shophub.store_app.model.Product;
import com.shophub.store_app.repositories.CategoryRepository;
import com.shophub.store_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("StoreProductService")
public class StoreProductService implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Optional<Category> categoryDB=categoryRepository.findByName(request.getCategory().getName());
        Product product=CreateProductRequestDTO.convertToProduct(request);
        if(categoryDB.isEmpty()){
            product.getCategory().setCreatedAt(new Date());
            product.getCategory().setUpdatedAt(new Date());
            product.getCategory().setIsDeleted(false);
            Category category=categoryRepository.save(product.getCategory());
            product.setCategory(category);
        }else{
            product.setCategory(categoryDB.get());
        }
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        product.setIsDeleted(false);
        Product response=productRepository.save(product);
        return CreateProductResponseDTO.convertToProductResponseDTO(response);
    }

    @Override
    public ProductResponseDTOs getAllProduct() {
        List<Product> products=productRepository.findAll();
        ProductResponseDTOs response=new ProductResponseDTOs();
        response.setProducts(new ArrayList<>());
        products.forEach((product -> {
            response.getProducts().add(ProductResponseDTOs.convertToProductResponseDTO(product));
        }));
        return response;
    }

    @Override
    public ProductResponseDTO getProduct(Long productId) {
        Optional<Product> product=productRepository.findById(productId);
        if(product.isEmpty()){
            throw new InvalidRequestException("Product not found");
        }
        return GetProductResponseDTO.convertToProductResponseDTO(product.get());
    }

    @Override
    public ProductResponseDTO updateProduct(Long productId,ProductRequestDTO request) {
        Optional<Product> dbProduct=productRepository.findById(productId);
        if(dbProduct.isEmpty()){
            throw new InvalidRequestException("Invalid Request");
        }
        if(StringUtils.hasLength(request.getName())){
            dbProduct.get().setName(request.getName());
        }
        if(StringUtils.hasLength(request.getDescription())){
            dbProduct.get().setDescription(request.getDescription());
        }
        if(StringUtils.hasLength(request.getImageUrl())){
            dbProduct.get().setImageUrl(request.getImageUrl());
        }
        if(StringUtils.hasLength(request.getCategory().getName())){
            Optional<Category> dbCategory=categoryRepository.findByName(request.getCategory().getName());
            if(dbCategory.isEmpty()){
                Category newCategory=new Category();
                newCategory.setName(request.getCategory().getName());
                newCategory.setCreatedAt(new Date());
                newCategory.setUpdatedAt(new Date());
                newCategory.setIsDeleted(false);
                newCategory=categoryRepository.save(newCategory);
                dbProduct.get().setCategory(newCategory);
            }else{
                dbProduct.get().setCategory(dbCategory.get());
            }
        }
        if(request.getPrice()!=null&&request.getPrice()!=0){
            dbProduct.get().setPrice(request.getPrice());
        }
        Product product=productRepository.save(dbProduct.get());
        return UpdateProductResponseDTO.convertToProductResponseDTO(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        try{
            productRepository.deleteById(productId);
        } catch (InvalidRequestException e) {
            throw new InvalidRequestException(e.getMessage());
        }
    }
}
