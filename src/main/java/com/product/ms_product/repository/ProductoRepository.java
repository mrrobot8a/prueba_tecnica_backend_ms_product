package com.product.ms_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.ms_product.entities.Producto;

import java.util.UUID;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID> {
}