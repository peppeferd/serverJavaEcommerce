package com.joesalt.tutorial.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_inventory")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "size")
    private String size;

    @Column(name = "new_arrival")
    private Boolean new_arrival;

}