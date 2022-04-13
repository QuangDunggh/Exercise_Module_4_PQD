package com.cg.service.impl;

import com.cg.model.Customer;
import com.cg.repository.ICustomerRepository;
import com.cg.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceCustomer implements IServiceCustomer {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public boolean insertWithStoreProcedure(Customer customer) {
        return customerRepository.insertWithStoreProcedure(customer);
    }
}
