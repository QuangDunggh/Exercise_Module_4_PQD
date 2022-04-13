package com.cg.service.impl;

import com.cg.model.Customer;
import com.cg.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateCustomerServiceImpl implements ICustomerService {

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findOne() {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean isExist(Long id) {
        return false;
    }
}
