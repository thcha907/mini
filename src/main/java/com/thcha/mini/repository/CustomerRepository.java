package com.thcha.mini.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.thcha.mini.entity.Customer;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public abstract class CustomerRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long save(Customer customer) {
        if (customer.getId() == null) {
            em.persist(customer);
        } else {
            em.merge(customer);
        }
        return customer.getId();
    }

    public Customer findOne(Long id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return em.createQuery("select c from customer c", Customer.class).getResultList();
    }

    public List<Customer> findByName(String name) {
        return em.createQuery("select c from customer c where c.name = :name", Customer.class)
                .setParameter("name", name).getResultList();
    }

    public List<Customer> findByPersonSsn(String personSsn) {
        return em.createQuery("select c from customer c where c.personSsn = :personSsn", Customer.class)
                .setParameter("personSsn", personSsn)
                .getResultList();
    }

    public List<Customer> findByCompanyBizNo(String companyBizNo) {
        return em.createQuery("select c from customer c where c.companyBizNo = :companyBizNo", Customer.class)
                .setParameter("companyBizNo", companyBizNo)
                .getResultList();
    }
}