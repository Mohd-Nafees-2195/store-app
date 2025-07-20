package com.shophub.store_app.DTOs.searchDTOs;

import lombok.Data;

public enum SortingCriteria {
    PRICE_LOW_TO_HIGH,
    PRICE_HIGH_TO_LOW,
    RATING_HIGH_TO_LOW,
    RATING_LOW_TO_HIGH,
    RELEVANCE,
    POPULARITY
}
