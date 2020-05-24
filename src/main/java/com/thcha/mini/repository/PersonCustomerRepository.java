package com.thcha.mini.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.thcha.mini.entity.PersonCustomer;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PersonCustomerRepository {

    @PersistenceContext
    private final EntityManager em;
    
    public Long save(PersonCustomer personCustomer) {
        if (personCustomer.getId() == null) {
            em.persist(personCustomer);
        } else {
            em.merge(personCustomer);
        }
        return personCustomer.getId();
    }

    public PersonCustomer findOne(Long id) {
        return em.find(PersonCustomer.class, id);
    }

    public List<PersonCustomer> findAll() {
        return em.createQuery("select c from personCustomer c", PersonCustomer.class)
            .getResultList();
    }

    public List<PersonCustomer> findByName(String name) {
        return em.createQuery("select c from personCustomer c where c.name = :name", PersonCustomer.class)
            .setParameter("name", name)
            .getResultList();
    }

    public List<PersonCustomer> findByPersonSsn(String personSsn) {
        return em.createQuery("select c from personCustomer c where c.personSsn = :personSsn", PersonCustomer.class)
            .setParameter("personSsn", personSsn)
            .getResultList();
    }    

    public List<PersonCustomer> findByCompanyBizNo(String companyBizNo) {
        return em.createQuery("select c from personCustomer c where c.companyBizNo = :companyBizNo", PersonCustomer.class)
            .setParameter("companyBizNo", companyBizNo)
            .getResultList();
    }    
    
}