package com.example.facturacion.controller;

import com.example.facturacion.model.factura;
import com.example.facturacion.service.facturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public final class facturacontroller {
    private final facturaService facturaService;

    public facturacontroller(facturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping
    public factura guardarFactura(@RequestBody factura factura) {
        return facturaService.guardarFactura(factura);
    }

    @GetMapping
    public List<factura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public factura obtenerFacturaPorId(@PathVariable Long id) {
        return facturaService.obtenerFacturaPorId(id);
    }
}