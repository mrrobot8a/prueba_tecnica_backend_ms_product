package com.product.ms_product.mapping;

import org.mapstruct.*;

import com.product.ms_product.dtos.ProductoRequestDTO;
import com.product.ms_product.dtos.ProductoResponseDTO;
import com.product.ms_product.entities.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true),
        @Mapping(target = "name", source = "nombre"),
        @Mapping(target = "description", source = "descripcion"),
        @Mapping(target = "price", source = "precio")
    })
    Producto toEntity(ProductoRequestDTO dto);

    
    ProductoResponseDTO toDto(Producto producto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "name", source = "nombre"),
            @Mapping(target = "description", source = "descripcion"),
            @Mapping(target = "price", source = "precio")
    })
    void updateFromDto(ProductoRequestDTO dto, @MappingTarget Producto producto);
}