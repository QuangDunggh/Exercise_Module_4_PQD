package com.cg.repository.impl;

import com.cg.model.Customer;
import com.cg.repository.ICustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class CustomerRepositoryImpl implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean insertWithStoreProcedure(Customer customer) {
        String str = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(str);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() == 0;
    }
}
