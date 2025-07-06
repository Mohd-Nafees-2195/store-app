package com.shophub.store_app.service;

import com.shophub.store_app.DTOs.fakestoreDTO.FakeProductRequestDTO;
import com.shophub.store_app.DTOs.fakestoreDTO.FakeProductResponseDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTOs;
import com.shophub.store_app.DTOs.storeDTO.ProductRequestDTO;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Service("FakeStoreProductService")
//@Primary
public class FakeStoreProductService implements ProductService{

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        FakeProductRequestDTO fakeRequestDTO=new FakeProductRequestDTO();
        fakeRequestDTO.copy(requestDTO);
        FakeProductResponseDTO fakeResponseDTO=restTemplate.postForObject("https://fakestoreapi.com/products",fakeRequestDTO,FakeProductResponseDTO.class);
        if(Objects.isNull(fakeResponseDTO)){
            return null;
        }
        return fakeResponseDTO.copy(new ProductResponseDTO());
    }

    @Override
    public ProductResponseDTOs getAllProduct() {
        FakeProductResponseDTO[] fakeProducts=restTemplate.getForObject("https://fakestoreapi.com/products",FakeProductResponseDTO[].class);
        ProductResponseDTOs responseDTOs=new ProductResponseDTOs();
        responseDTOs.setProducts(new ArrayList<>());
        Arrays.stream(fakeProducts).forEach((fakeProduct)->{
            responseDTOs.getProducts().add(fakeProduct.copy(new ProductResponseDTO()));
        });
        return responseDTOs;
    }

    @Override
    public ProductResponseDTO getProduct(Long productId) {
        FakeProductResponseDTO fakeResponseDTO=restTemplate.getForObject("https://fakestoreapi.com/products/"+productId,FakeProductResponseDTO.class);
        if(fakeResponseDTO==null) return null;
        return fakeResponseDTO.copy(new ProductResponseDTO());
    }

    @Override
    public ProductResponseDTO updateProduct(Long productId,ProductRequestDTO requestDTO) {
        FakeProductRequestDTO fakeRequestDTO=new FakeProductRequestDTO();
        fakeRequestDTO.copy(requestDTO);
//       restTemplate.("https://fakestoreapi.com/products/"+productId,fakeRequestDTO,FakeProductResponseDTO.class);
        FakeProductResponseDTO fakeResponseDTO = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + productId,
                HttpMethod.PUT,
                new HttpEntity<>(fakeRequestDTO),
                FakeProductResponseDTO.class
        ).getBody();
        return fakeResponseDTO.copy(new ProductResponseDTO());
    }

    @Override
    public void deleteProduct(Long productId) {
         restTemplate.delete("https://fakestoreapi.com/products/"+productId);
    }
}
