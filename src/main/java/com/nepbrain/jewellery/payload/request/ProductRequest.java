package com.nepbrain.jewellery.payload.request;

import com.nepbrain.jewellery.entity.CustomerEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {


    private String name;
    private String description;
    private double price;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private CustomerEntity customer;
}
