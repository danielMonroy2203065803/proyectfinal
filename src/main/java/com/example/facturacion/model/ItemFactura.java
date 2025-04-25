package com.example.facturacion.model;

import com.example.producto.model.producto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double precioUnitario;

    @ManyToOne
    private producto producto;
}