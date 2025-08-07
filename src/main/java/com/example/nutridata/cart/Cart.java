package com.example.nutridata.cart;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
    @Getter @Setter
    public class Cart{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Integer productQuantity;

        @CreationTimestamp
        @Column(updatable = false)
        private Timestamp createdAt;

        @UpdateTimestamp
        private Timestamp updatedAt;
    }


