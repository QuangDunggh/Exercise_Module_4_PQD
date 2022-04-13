package com.cg.service;
import com.cg.model.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findOne();

    Customer save(Customer customer);

    List<Customer> save (List<Customer> customers);

    public boolean isExist(Long id);
}
