package com.example.nutridata.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapea un tipo enumerado (enum) de Java a una columna de la base de datos.
    @Enumerated(EnumType.STRING)
    @Column(name = "name",nullable = false, unique = true)
    private NameRol name;
}
