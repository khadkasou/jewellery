package com.nepbrain.jewellery.payload.request;

import com.nepbrain.jewellery.entity.ProductEntity;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String address;
    private List<ProductEntity> products;
}
