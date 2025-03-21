package com.nepbrain.jewellery.entity;

import com.nepbrain.core.entity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseAuditEntity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String address;
    @OneToMany(mappedBy ="customer" , cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<ProductEntity> products;

}
