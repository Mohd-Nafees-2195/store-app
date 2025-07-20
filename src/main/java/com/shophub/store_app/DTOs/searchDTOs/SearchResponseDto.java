package com.shophub.store_app.DTOs.searchDTOs;

import com.shophub.store_app.DTOs.storeDTO.ProductResponseDTO;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class SearchResponseDto {
    private Page<ProductResponseDTO> products;
}
