package com.nepbrain.jewellery.entity;

import com.nepbrain.core.entity.BaseAuditEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity extends BaseAuditEntity {

    private String name;
    private String description;
    private double price;
    private LocalDate orderDate;
    private LocalDate deliveryDate;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private CustomerEntity customer;
}
