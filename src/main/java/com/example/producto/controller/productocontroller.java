package com.example.producto.controller; // Asegúrate de que el paquete coincida con tu estructura

import com.example.producto.model.producto; // Clase con mayúscula
import com.example.producto.service.productoservice; // Clase con mayúscula
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class productocontroller { // Clase con mayúscula
    private final productoservice productoService; // Nombre del campo corregido

    @GetMapping
    public List<producto> listarProductos() { // Nombre del método en camelCase
        return productoService.listarProductos(); // Usa el campo correcto
    }

    @PostMapping
    public producto guardarProducto(@RequestBody producto producto) {
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/{id}")
    public producto obtenerProductoPorId(@PathVariable Long id) {
        return productoservice.obtenerProductoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}