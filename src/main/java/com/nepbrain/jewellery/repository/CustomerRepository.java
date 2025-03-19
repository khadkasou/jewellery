package com.nepbrain.jewellery.repository;

import com.nepbrain.jewellery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
