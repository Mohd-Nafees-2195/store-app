package com.shophub.store_app.controller;

import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTOs;
import com.shophub.store_app.DTOs.storeDTO.ProductRequestDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTO;
import com.shophub.store_app.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO requestDTO){
        return productService.createProduct(requestDTO);
    }

    @GetMapping("/")
    public ProductResponseDTOs getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{productId}")
    public ProductResponseDTO getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }
    @PutMapping("/{productId}")
    public ProductResponseDTO updateProduct(@PathVariable Long productId ,@RequestBody ProductRequestDTO requestDTO){
        return productService.updateProduct(productId,requestDTO);
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return "Product deleted successfully!!";
    }
}
