package com.nepbrain.jewellery.service.impl;

import com.nepbrain.core.builder.ServiceResponseBuilder;
import com.nepbrain.core.exception.JewelleryException;
import com.nepbrain.core.payload.JewelleryResponse;
import com.nepbrain.jewellery.entity.CustomerEntity;
import com.nepbrain.jewellery.entity.ProductEntity;
import com.nepbrain.jewellery.mapper.CustomerMapper;
import com.nepbrain.jewellery.payload.request.CustomerRequest;
import com.nepbrain.jewellery.repository.CustomerRepository;
import com.nepbrain.jewellery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public JewelleryResponse addCustomer(CustomerRequest request) throws JewelleryException {
        CustomerEntity customer = customerRepository.findByPhone(request.getPhone());
        if (customer != null) {
            throw  new JewelleryException("CustomerController with same phone number already exists.");
        }
        CustomerEntity addCustomer = CustomerMapper.INSTANCE.toEntity(request);
        if (addCustomer.getProducts() != null) {
            for (ProductEntity product : addCustomer.getProducts()) {
                product.setCustomer(addCustomer);
            }
        }
        customerRepository.save(addCustomer);
        return ServiceResponseBuilder.buildSuccessResponse("CustomerController added successfully.");
    }

    @Override
    public JewelleryResponse updateCustomer(CustomerRequest request) {
        return null;
    }

    @Override
    public JewelleryResponse getAllCustomers() {
        return null;
    }

    @Override
    public JewelleryResponse getCustomerDetails(String customerId) {
        return null;
    }
}
