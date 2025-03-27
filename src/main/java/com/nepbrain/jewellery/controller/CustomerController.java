package com.nepbrain.jewellery.controller;

import com.nepbrain.core.exception.JewelleryException;
import com.nepbrain.core.payload.JewelleryResponse;
import com.nepbrain.jewellery.annotation.JewelleryRestController;
import com.nepbrain.jewellery.payload.request.CustomerRequest;
import com.nepbrain.jewellery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.nepbrain.jewellery.util.PathConstant.CUSTOMER;

@RequiredArgsConstructor
@JewelleryRestController
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(CUSTOMER)
    public ResponseEntity<JewelleryResponse> createCustomer(@RequestBody CustomerRequest request) throws JewelleryException {
        return ResponseEntity.ok().body(customerService.addCustomer(request));
    }


}
