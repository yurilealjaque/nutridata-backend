package com.example.nutridata.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "usuario")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    private String email;
    @Column(name = "telefono")
    private String phoneNumber;
    @Column(name = "contraseña")
    private String password;
    @Column(name = "ocupacion" )
    private String occupation;
    @Column(name ="fecha_registro")
    private Timestamp registerDate;
    @Column(name = "activo")
    private Boolean active;

}
