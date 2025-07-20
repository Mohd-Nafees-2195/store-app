package com.shophub.store_app.DTOs.searchDTOs;

import lombok.Data;

import java.util.List;

@Data
public class FilterDto {
    private String key;
    private List<String> values;
}
