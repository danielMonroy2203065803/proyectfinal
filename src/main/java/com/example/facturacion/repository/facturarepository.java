package com.example.facturacion.repository;

import com.example.facturacion.model.factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface facturarepository extends JpaRepository<factura, Long> {
}
