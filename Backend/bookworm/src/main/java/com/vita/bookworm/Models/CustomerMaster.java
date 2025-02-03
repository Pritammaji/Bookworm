package com.vita.bookworm.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class CustomerMaster {
    @Id
    @GeneratedValue
    @Column(name = "customer_id" , columnDefinition = "int default 1")
    private int customerId;

    @Column(nullable = true, unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String customerEmail; 

    private String customerName;

    private String customerPassword;

    private LocalDate dob; 

    private Integer age;

    @Column(nullable = true)
    private String pan;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phoneNumber;

    @OneToOne(targetEntity = CartMaster.class)
    @JoinColumn(name = "cart_id", nullable = true)
    private CartMaster cartId;

    @OneToOne(targetEntity = MyShelf.class)
    @JoinColumn(name = "shelf_id", nullable = true)
    private MyShelf shelfId;
}