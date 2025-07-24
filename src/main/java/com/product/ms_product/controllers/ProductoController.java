package com.product.ms_product.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.ms_product.dtos.ProductoRequestDTO;
import com.product.ms_product.dtos.ProductoResponseDTO;
import com.product.ms_product.service.ProductoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "apiKey")
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/create")
    public ResponseEntity<ProductoResponseDTO> create(@RequestBody @Valid ProductoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductoResponseDTO> update(
        @PathVariable UUID id,
        @RequestBody @Valid ProductoRequestDTO dto
    ) {
        return ResponseEntity.ok(productoService.update(id, dto));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ProductoResponseDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(productoService.findById(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<List<ProductoResponseDTO>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }
}