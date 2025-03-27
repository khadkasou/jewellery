package com.nepbrain.jewellery.repository;

import com.nepbrain.jewellery.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    CustomerEntity findByPhone(String phone);
}
