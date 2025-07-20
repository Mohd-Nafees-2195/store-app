package com.shophub.store_app.controller;

import com.shophub.store_app.DTOs.searchDTOs.FilterDto;
import com.shophub.store_app.DTOs.searchDTOs.SearchResponseDto;
import com.shophub.store_app.DTOs.searchDTOs.SortingCriteria;
import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTO;
import com.shophub.store_app.model.Product;
import com.shophub.store_app.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    SearchService searchService;

    public SearchController(SearchService searchService){
         this.searchService=searchService;
    }

    @GetMapping
    public SearchResponseDto search(@RequestParam("query") String query,
                                    @RequestParam("filters")List<FilterDto> filters,
                                    @RequestParam("sortBy")SortingCriteria sortingCriteria,
                                    @RequestParam("pageNumber") int pageNumber,
                                    @RequestParam("pageSize")int pageSize){
        SearchResponseDto response=new SearchResponseDto();

        Page<Product> products=searchService.search(query,filters,sortingCriteria,pageNumber,pageSize);
        response.setProducts(products.map(ProductResponseDTO::convertToProductResponseDTO));
        return  response;
    }

    @GetMapping("/byCategory")
    public SearchResponseDto simpleSearch(@RequestParam("query") String query,
                                          @RequestParam("category") Long categoryId,
                                          @RequestParam("pageNumber") int pageNumber,
                                          @RequestParam("pageSize")int pageSize,
                                          @RequestParam("sortingAttribute") String sortingAttribute
                                          ){
        SearchResponseDto response=new SearchResponseDto();
        Page<Product> products=searchService.simpleSearch(query,categoryId,pageNumber,pageSize,sortingAttribute);
        response.setProducts(products.map(ProductResponseDTO::convertToProductResponseDTO));
        return response;
    }
}
