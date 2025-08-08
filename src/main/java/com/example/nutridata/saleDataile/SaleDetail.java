package com.example.nutridata.saleDataile;

import com.example.nutridata.product.Product;
import com.example.nutridata.sale.Sale;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;


@Entity
@Getter @Setter
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "saleId", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    private Integer detailQuantity;

    private Double unitPrice;

    private Double totalPrice;
}
