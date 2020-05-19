package com.thcha.mini.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.thcha.mini.entity.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Customer customer) {
        em.persist(customer);
        return customer.getId();
    }

    public Customer find(Long id) {
        return em.find(Customer.class, id);
    }
}