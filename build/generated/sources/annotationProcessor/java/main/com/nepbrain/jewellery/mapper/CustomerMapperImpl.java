package com.nepbrain.jewellery.mapper;

import com.nepbrain.jewellery.entity.CustomerEntity;
import com.nepbrain.jewellery.entity.ProductEntity;
import com.nepbrain.jewellery.payload.request.CustomerRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-19T14:24:43+0545",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity toEntity(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName( request.getFirstName() );
        customerEntity.setMiddleName( request.getMiddleName() );
        customerEntity.setLastName( request.getLastName() );
        customerEntity.setEmail( request.getEmail() );
        customerEntity.setPhone( request.getPhone() );
        customerEntity.setDateOfBirth( request.getDateOfBirth() );
        customerEntity.setAddress( request.getAddress() );
        List<ProductEntity> list = request.getProducts();
        if ( list != null ) {
            customerEntity.setProducts( new ArrayList<ProductEntity>( list ) );
        }

        return customerEntity;
    }
}
