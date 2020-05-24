package com.thcha.mini.service;

import java.util.List;

import com.thcha.mini.entity.CompanyCustomer;
import com.thcha.mini.repository.CompanyCustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyCustomerService {

    @Autowired
    private final CompanyCustomerRepository companyCustomerRepository;

    @Transactional
    public Long save(CompanyCustomer companyCustomer) {
        companyCustomerRepository.save(companyCustomer);
        return companyCustomer.getId();
    }

    public List<CompanyCustomer> findCustoemrs() {
        return companyCustomerRepository.findAll();
    }

    public CompanyCustomer findOne(Long customerId) {
        return companyCustomerRepository.findOne(customerId);
    }

    public List<CompanyCustomer> findByName(String name) {
        return companyCustomerRepository.findByName(name);
    }

    public List<CompanyCustomer> findByCompanyBizNo(String companyBizNo) {
        return companyCustomerRepository.findByCompanyBizNo(companyBizNo);
    }
}
