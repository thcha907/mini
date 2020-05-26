package com.thcha.mini.service;

import java.util.List;

import com.thcha.mini.entity.Customer;
import com.thcha.mini.repository.CustomerRepository;

//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// import java.util.ArrayList;
// import java.util.List;

// import com.thcha.mini.dto.CustomersDto;
// import com.thcha.mini.entity.CompanyCustomer;
// import com.thcha.mini.entity.Customer;
// import com.thcha.mini.entity.PersonCustomer;
// import com.thcha.mini.repository.CompanyCustomerRepository;
// import com.thcha.mini.repository.CustomerRepository;
// import com.thcha.mini.repository.PersonCustomerRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    public List<Customer> findAllPage(int age, Pageable pageable) {
        //List<Customer> customers = customerRepository.findAllPage() findByAge(int age, Pageable pageable);
        return null;
    }

}
