package com.example.facturacion.service;

import com.example.facturacion.model.factura;
import com.example.facturacion.repository.facturarepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class facturaService {
    private final facturarepository facturarepository;

    public factura guardarFactura(factura factura) {
        return facturarepository.save(factura);
    }

    public List<factura> listarFacturas() {
        return facturarepository.findAll();
    }

    public factura obtenerFacturaPorId(Long id) {
        return facturarepository.findById(id).orElseThrow();
    }
}