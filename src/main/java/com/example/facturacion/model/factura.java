package com.example.facturacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private Date fecha;
    private double total;

    @OneToMany(cascade = CascadeType.ALL)
    public List<ItemFactura> items;
}
