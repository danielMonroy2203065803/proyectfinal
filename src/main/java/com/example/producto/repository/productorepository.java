package com.example.producto.repository;

import com.example.producto.model.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productorepository extends JpaRepository<producto, Long> {
}
