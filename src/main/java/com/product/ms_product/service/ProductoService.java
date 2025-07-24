package com.product.ms_product.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.ms_product.dtos.ProductoRequestDTO;
import com.product.ms_product.dtos.ProductoResponseDTO;
import com.product.ms_product.entities.Producto;
import com.product.ms_product.exception.ResourceNotFoundException;
import com.product.ms_product.mapping.ProductoMapper;
import com.product.ms_product.repository.ProductoRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper mapper;

    @Transactional
    public ProductoResponseDTO create(ProductoRequestDTO dto) {
        Producto producto = mapper.toEntity(dto);
        return mapper.toDto(productoRepository.save(producto));
    }

    @Transactional
    public ProductoResponseDTO update(UUID id, ProductoRequestDTO dto) {
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        mapper.updateFromDto(dto, producto);
        return mapper.toDto(productoRepository.save(producto));
    }

    @Transactional(readOnly = true)
    public ProductoResponseDTO findById(UUID id) {
        return productoRepository.findById(id)
            .map(mapper::toDto)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
    }

    @Transactional(readOnly = true)
    public List<ProductoResponseDTO> findAll() {
        return productoRepository.findAll().stream()
            .map(mapper::toDto)
            .toList();
    }
}