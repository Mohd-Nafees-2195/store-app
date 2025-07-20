package com.shophub.store_app.service;

import com.shophub.store_app.DTOs.searchDTOs.FilterDto;
import com.shophub.store_app.DTOs.searchDTOs.SortingCriteria;
import com.shophub.store_app.model.Product;
import com.shophub.store_app.repositories.ProductRepository;
import com.shophub.store_app.service.filteringService.FilterFactory;
import com.shophub.store_app.service.sortingService.SorterFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    //How to calculate pagination
    //formula =>> pageSize*(pageNumber-1) -> to -> (pageSize*pageNumber)-1
    //ex1- pageNumber=1 and pageSize=5 Then ===>>> [0 to 4]
    //ex2- pageNumber=2 and pageSize=5 Then ===>>> [5 to 9]

    public Page<Product> search(String query, List<FilterDto> filters, SortingCriteria sortingCriteria,int pageNumber,int pageSize) {
        List<Product> products=productRepository.findByName(query);

        for (FilterDto filterDto:filters){
            products= FilterFactory.getFilterFromKey(filterDto.getKey())
                    .apply(products,filterDto.getValues());
        }
        products= SorterFactory.getSorterByCriteria(sortingCriteria).sort(products);
        List<Product> productsOnPage=new ArrayList<>();

        for(int i=pageSize*(pageNumber-1);i<=pageNumber*pageSize-1;++i){
            productsOnPage.add(products.get(i));
        }

        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return  new PageImpl<>(productsOnPage,pageable,products.size());
    }

    public Page<Product> simpleSearch(String query, Long categoryId, int pageNumber, int pageSize, String sortingAttribute){
      //Here sortingAttribute is any column of the table by which we have to sort

        //Query -> select * from product where name like '%query%'
                 //and categoryId=categoryId
                 //and pageSize offset pageSize*pageNumber order by sortingAttribute;
        Page<Product> products= productRepository.findAllByNameAndCategory_id(query,categoryId,PageRequest.of(pageNumber,pageSize, Sort.by(sortingAttribute).descending()));
        return products;
    }
}
