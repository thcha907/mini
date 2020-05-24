package com.thcha.mini.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.thcha.mini.entity.CompanyCustomer;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CompanyCustomerRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long save(CompanyCustomer companyCustomer) {
        if (companyCustomer.getId() == null) {
            
            em.persist(companyCustomer);
        } else {
            em.merge(companyCustomer);
        }
        return companyCustomer.getId();
    }

    public CompanyCustomer findOne(Long id) {
        return em.find(CompanyCustomer.class, id);
    }

    public List<CompanyCustomer> findAll() {
        return em.createQuery("select c from companyCustomer c", CompanyCustomer.class)
            .getResultList();
    }

    public List<CompanyCustomer> findByName(String name) {
        return em.createQuery("select c from companyCustomer c where c.name = :name", CompanyCustomer.class)
            .setParameter("name", name)
            .getResultList();
    }

    public List<CompanyCustomer> findByPersonSsn(String companyBizNo) {
        return em.createQuery("select c from companyCustomer c where c.companyBizNo = :companyBizNo", CompanyCustomer.class)
            .setParameter("companyBizNo", companyBizNo)
            .getResultList();
    }    

    public List<CompanyCustomer> findByCompanyBizNo(String companyBizNo) {
        return em.createQuery("select c from companyCustomer c where c.companyBizNo = :companyBizNo", CompanyCustomer.class)
            .setParameter("companyBizNo", companyBizNo)
            .getResultList();
    }    

    
}