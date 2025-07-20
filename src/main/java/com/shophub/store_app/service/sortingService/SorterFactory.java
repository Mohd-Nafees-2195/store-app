package com.shophub.store_app.service.sortingService;

import com.shophub.store_app.DTOs.searchDTOs.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterByCriteria(SortingCriteria sortingCriteria){
        return switch (sortingCriteria){
            case RELEVANCE -> null;
            case POPULARITY -> null;
            case PRICE_HIGH_TO_LOW -> new PriceHighToLowSorter();
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
            case RATING_HIGH_TO_LOW -> null;
            case RATING_LOW_TO_HIGH -> null;
            default -> null;
        };
    }
}
