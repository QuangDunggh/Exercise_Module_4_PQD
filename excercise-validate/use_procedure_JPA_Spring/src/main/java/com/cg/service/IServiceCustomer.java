package com.cg.service;

import com.cg.model.Customer;

public interface IServiceCustomer {
    boolean insertWithStoreProcedure(Customer customer);
}
