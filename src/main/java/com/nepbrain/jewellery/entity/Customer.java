package com.nepbrain.jewellery.entity;

import com.nepbrain.core.entity.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends BaseAuditEntity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private Date dateOfBirth;

}
