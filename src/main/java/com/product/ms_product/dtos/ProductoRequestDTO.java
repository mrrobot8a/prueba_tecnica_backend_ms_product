package com.product.ms_product.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @PositiveOrZero(message = "El precio debe ser positivo o cero")
    private BigDecimal precio;

    @Size(min = 5, max = 50, message = "El SKU debe tener entre 5 y 50 caracteres")
    private String sku;

   
    @Builder.Default
    private boolean active = true;
}