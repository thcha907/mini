package com.thcha.mini.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thcha.mini.dto.Address;
import com.thcha.mini.dto.CustomerRestReturnDto;
import com.thcha.mini.dto.Data;
import com.thcha.mini.entity.Customer;
import com.thcha.mini.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    @Autowired
    private final CustomerRepository customerRepository;

    @GetMapping("/customer")
    public CustomerRestReturnDto findAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        
        CustomerRestReturnDto returnDto = makeRestReturnDto(customers);
        
        return returnDto;
    }

    @GetMapping("/customer/{id}")
    public CustomerRestReturnDto findById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).get();
        
        CustomerRestReturnDto returnDto = makeRestReturnDto(new ArrayList<>(Arrays.asList(new Customer[]{customer})));
        
        return returnDto;
    }

    public CustomerRestReturnDto makeRestReturnDto(List<Customer> customers) {       

        CustomerRestReturnDto returnDto = new CustomerRestReturnDto();
        
        if (!customers.isEmpty()) {
            returnDto.setCount(customers.size());
            for (Customer customer : customers) {
                Data data = new Data();

                data.setId(customer.getId()); 
                data.setName(customer.getName()); 
                data.setAddress(new Address(customer.getAddress().getCity(), customer.getAddress().getStreet(), customer.getAddress().getZipcode()));
                data.setLineCount(customer.getLineCount());
                data.setHandphone(customer.getCustomerType().equalsIgnoreCase("PERSON") ? customer.getPersonPhoneNo() : customer.getCompanyPhoneNo());
            
                returnDto.addListData(data);
            }
        }
        
        return returnDto;
    }

}