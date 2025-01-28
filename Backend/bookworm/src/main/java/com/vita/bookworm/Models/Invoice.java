package com.vita.bookworm.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int invoiceId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private CustomerMaster customerId;
    
    @Column(nullable = true)
    private double amount;

    @Column(nullable = true)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = true,referencedColumnName = "cart_id")
    private CartMaster cartId;

//     @OneToMany(mappedBy = "invoice") // 'invoice' refers to the field in InvoiceDetails
//     private Set<InvoiceDetails> invoiceDetails;
}
