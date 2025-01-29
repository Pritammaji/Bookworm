package com.vita.bookworm.Models;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RoyaltyCalculation {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="RoyCalId", length=10)
    private int royaltyCalculationId;

    @ManyToOne(targetEntity = Invoice.class)
    private Invoice invoice;

	@ManyToOne
	private BeneficiaryMaster beneficiaryMaster;

	@Column(nullable=false)
    private LocalDate royaltyTranDate;

    @ManyToOne
    private ProductMaster product;

	@Column(nullable=false)
    private int quantity;

	@Column(nullable=false)
    private String transactionType;

	@Column(nullable=false)
    private double salesPrice;

	@Column(nullable=false)
    private double basePrice;

	@Column(nullable=false)
    private double royaltyOnBasePrice;

}