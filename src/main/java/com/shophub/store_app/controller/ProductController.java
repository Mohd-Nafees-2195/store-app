package com.shophub.store_app.controller;

import com.shophub.store_app.DTOs.storeDTO.*;
import com.shophub.store_app.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("StoreProductService") ProductService productService){
        this.productService=productService;
    }

    @PostMapping
    public CreateProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO requestDTO){
        CreateProductResponseDTO response=new CreateProductResponseDTO();
        response.setProduct(productService.createProduct(requestDTO.getProduct()));
        return response;
    }

    @GetMapping
    public ProductResponseDTOs getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{productId}")
    public GetProductResponseDTO getProduct(@PathVariable Long productId){
        GetProductResponseDTO response=new GetProductResponseDTO();
        response.setProduct(productService.getProduct(productId));
        return response;
    }
    @PatchMapping("/{productId}")
    public UpdateProductResponseDTO updateProduct(@PathVariable Long productId ,@RequestBody UpdateProductRequestDTO request){
        UpdateProductResponseDTO response=new UpdateProductResponseDTO();
        response.setProduct(productService.updateProduct(productId,request.getProduct()));
        return response;
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return "Product deleted successfully!!";
    }
}
