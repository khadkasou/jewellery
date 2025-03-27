package com.nepbrain.jewellery.service;

import com.nepbrain.core.exception.JewelleryException;
import com.nepbrain.core.payload.JewelleryResponse;
import com.nepbrain.jewellery.payload.request.CustomerRequest;

public interface CustomerService {

    JewelleryResponse addCustomer(CustomerRequest request) throws JewelleryException;
    JewelleryResponse updateCustomer(CustomerRequest request);
    JewelleryResponse getAllCustomers();
    JewelleryResponse getCustomerDetails(String customerId);

}
