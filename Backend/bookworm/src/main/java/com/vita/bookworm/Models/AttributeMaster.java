package com.vita.bookworm.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AttributeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attributeId;

    @Column(nullable = false)
    private String attributeName;
}
