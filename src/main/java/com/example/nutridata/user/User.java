package com.example.nutridata.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter @Setter
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String occupation;
    private Timestamp createdAt;
    private Boolean active;

}
