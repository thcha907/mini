package com.thcha.mini.service;

import java.util.List;

import com.thcha.mini.entity.PersonCustomer;
import com.thcha.mini.repository.PersonCustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonCustomerService {

    @Autowired
    private final PersonCustomerRepository personCustomerRepository;

    /**
     * 회원등록
     */
    @Transactional
    public Long save(PersonCustomer personCustomer) {
        personCustomerRepository.save(personCustomer);
        return personCustomer.getId();
    }

    public List<PersonCustomer> findCustoemrs() {
        return personCustomerRepository.findAll();
    }

    public PersonCustomer findOne(Long customerId) {
        return personCustomerRepository.findOne(customerId);
    }

    public List<PersonCustomer> findByName(String name) {
        return personCustomerRepository.findByName(name);
    }

    public List<PersonCustomer> findByPersonSsn(String personSsn) {
        return personCustomerRepository.findByPersonSsn(personSsn);
    }
}
