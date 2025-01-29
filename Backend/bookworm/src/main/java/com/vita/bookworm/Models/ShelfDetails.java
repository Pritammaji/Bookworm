package com.vita.bookworm.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ShelfDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelf_dtl_id")
    private Integer shelfDetailId;

    // @OneToMany(targetEntity = MyShelf.class)
     @ManyToOne
     @JoinColumn(name = "shelf_id", nullable = true)
    private MyShelf shelf;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private ProductMaster product;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private CustomerMaster customer;

    @Column(nullable = true)
    private Double basePrice;

    @Column(nullable = true)
    private String tranType;

    @ManyToOne
    @JoinColumn(name = "rent_id", nullable = true)
    private RentDetails rentDetails;
}