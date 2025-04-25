package com.example.producto.service;

import com.example.producto.model.producto;
import com.example.producto.repository.productorepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class productoservice {
    private static final productorepository productorepository = null;

    public List<producto> listarProductos() {
        return productorepository.findAll();
    }

    public producto guardarProducto(producto producto) {
        return productorepository.save(producto);
    }

    public static producto obtenerProductoPorId(Long id) {
        return productorepository.findById(id).orElseThrow();
    }

    public void eliminarProducto(Long id) {
        productorepository.deleteById(id);
    }
}