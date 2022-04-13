package com.cg.repository;

import com.cg.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoreProcedure(Customer customer);
}
