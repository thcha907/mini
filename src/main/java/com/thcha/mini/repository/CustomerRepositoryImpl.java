package com.thcha.mini.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.thcha.mini.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findCustomerCustom(String name, String customerType) {

        String sql = "select c from Customer c where 1 = 1";

        if (!(name == null || name.isEmpty())) {
            sql += " and name LIKE '%"+ name +"%'"; 
        }
        if (!(customerType == null || customerType.trim().equals(""))) {
            sql += " and customerType = '"+ customerType +"'"; 
        }

        return em.createQuery(sql, Customer.class)
            .getResultList();
    }
}