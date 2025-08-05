package com.example.nutridata.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="producto")
@Getter @Setter
public class Product {

    @Id                                       // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    @Column(name = "nombre")
    private String nombre;
    private String descripcion;
    private int precio;
    private int stock;


    private int categoria_id;
    private boolean activo;
    private LocalDate fecha_creacion;

    public Product() {

    }
}