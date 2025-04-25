package com.example.facturacion.controller;

import com.example.facturacion.model.factura;
import com.example.facturacion.service.facturaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(facturacontroller.class) // <-- Prueba solo el controlador, no toda la aplicación
public class facturacontrollerTest {

    @Autowired
    private MockMvc mockMvc; // <-- Simulador de peticiones HTTP

    @MockBean
    public facturaService facturaService; // <-- Mock del servicio

    /* ------------------------------------ */
    /* TESTS PARA CADA ENDPOINT DEL CONTROLADOR */
    /* ------------------------------------ */

    @Test
    void listarTodasLasFacturas_debeRetornar200() throws Exception {
        // Configuración del mock
        when(facturaService.listarFacturas())
                .thenReturn(Collections.emptyList()); // <-- Retorna lista vacía

        // Ejecución y verificación
        mockMvc.perform(get("/api/facturas")) // <-- Simula GET /api/facturas
                .andExpect(status().isOk()) // <-- Espera HTTP 200
                .andExpect(jsonPath("$").isArray()); // <-- Espera un JSON array
    }

    @Test
    void crearFactura_debeRetornar201ConLocacion() throws Exception {
        // Datos de prueba
        factura facturaMock = new factura();
        facturaMock.setId(1L);
        facturaMock.setCliente("Cliente Ejemplo");

        // Configuración del mock
        when(facturaService.guardarFactura(any(factura.class)))
                .thenReturn(facturaMock); // <-- Simula el servicio

        // JSON de prueba (escapado para Java)
        String jsonFactura = """
        {
            "cliente": "Cliente Ejemplo",
            "items": []
        }
        """;

        // Ejecución y verificación
        mockMvc.perform(
                        post("/api/facturas")
                                .contentType(MediaType.APPLICATION_JSON) // <-- Indica que envías JSON
                                .content(jsonFactura) // <-- Cuerpo de la petición
                )
                .andExpect(status().isCreated()) // <-- Espera HTTP 201
                .andExpect(header().exists("Location")) // <-- Verifica header Location
                .andExpect(jsonPath("$.id").value(1)) // <-- Verifica ID en la respuesta
                .andExpect(jsonPath("$.cliente").value("Cliente Ejemplo"));
    }

    @Test
    void obtenerFacturaExistente_debeRetornar200() throws Exception {
        // Configuración del mock
        factura facturaMock = new factura();
        facturaMock.setId(1L);
        when(facturaService.obtenerFacturaPorId(1L))
                .thenReturn(facturaMock);

        // Ejecución y verificación
        mockMvc.perform(get("/api/facturas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void obtenerFacturaInexistente_debeRetornar404() throws Exception {
        // Configuración del mock
        when(facturaService.obtenerFacturaPorId(99L))
                .thenReturn(null); // <-- Simula factura no encontrada

        // Ejecución y verificación
        mockMvc.perform(get("/api/facturas/99"))
                .andExpect(status().isNotFound()); // <-- Espera HTTP 404
    }
}