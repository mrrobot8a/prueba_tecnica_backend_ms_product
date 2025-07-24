package com.product.ms_product.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponseDTO {
    @JsonProperty("id")
    private UUID id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("price")
    private BigDecimal price;
    
    @JsonProperty("description")
    private String description;

    @JsonProperty("active")
    private boolean active;
}
